import { useCallback, useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'

const API = 'http://localhost:8080/v1/user'
const today = () => { const now = new Date(); return [now.getFullYear(), String(now.getMonth() + 1).padStart(2, '0'), String(now.getDate()).padStart(2, '0')].join('-') }
const clock = (value) => value ? new Date(value).toLocaleTimeString([], { hour: '2-digit', minute: '2-digit', second: '2-digit' }) : '—'

export default function Dashboard() {
  const navigate = useNavigate()
  const [user, setUser] = useState(() => { try { return JSON.parse(localStorage.getItem('hrmsUser')) } catch { return null } })
  const [rows, setRows] = useState([])
  const [comment, setComment] = useState('')
  const [error, setError] = useState('')
  const [notice, setNotice] = useState('')
  const [busy, setBusy] = useState(false)

  const refresh = useCallback(async () => {
    if (!user?.emp_id) return
    try {
      const response = await fetch(`${API}/attendance/employee/${user.emp_id}`)
      if (!response.ok) throw new Error('Could not load attendance records. Check the backend.')
      setRows(await response.json())
      setError('')
    } catch (e) { setError(e.message) }
  }, [user])

  useEffect(() => { if (!user) navigate('/login', { replace: true }); else refresh() }, [user, navigate, refresh])
  if (!user) return null

  const todayRecord = rows.find((row) => row.attendancedate === today())
  async function mark(action) {
    setBusy(true); setError(''); setNotice('')
    try {
      const response = await fetch(`${API}/attendance/${action}`, {
        method: 'POST', headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ employee: { emp_id: user.emp_id }, attendancedate: today(), comment }),
      })
      const message = await response.text()
      if (!response.ok) throw new Error(message || 'Attendance request failed')
      setNotice(message); setComment(''); await refresh()
    } catch (e) { setError(e.message) } finally { setBusy(false) }
  }

  function logout() { localStorage.removeItem('hrmsUser'); setUser(null); navigate('/login') }
  return <main className="dashboard-shell">
    <header className="topbar">
      <div><div className="eyebrow">PEOPLE OPERATIONS</div><h1>Attendance dashboard</h1><p>Signed in as <strong>{user.empEmail}</strong></p></div>
      <button className="button button-outline" onClick={logout}>Log out</button>
    </header>
    <section className="welcome-strip"><div className="avatar">{(user.emp_name || 'E').slice(0, 1).toUpperCase()}</div><div><span className="muted">Welcome back</span><h2>{user.emp_name}</h2></div><div className="welcome-meta"><span className="muted">EMPLOYEE ID</span><strong>{user.emp_id}</strong></div><div className="welcome-meta"><span className="muted">TODAY</span><strong>{new Date().toLocaleDateString(undefined, { weekday: 'short', month: 'short', day: 'numeric', year: 'numeric' })}</strong></div></section>
    {(error || notice) && <div className={`flash ${error ? 'flash-error' : 'flash-success'}`} role="status">{error || notice}</div>}
    <section className="dashboard-grid">
      <article className="card action-card"><div className="card-heading"><div><span className="eyebrow">YOUR WORKDAY</span><h2>Clock in or out</h2></div><span className={`status-pill ${todayRecord?.outTime ? 'pill-green' : todayRecord?.inTime ? 'pill-blue' : 'pill-amber'}`}>{todayRecord?.outTime ? 'Completed' : todayRecord?.inTime ? 'Checked in' : 'Not started'}</span></div>
        <div className="time-summary"><div><span className="muted">CHECK IN</span><strong>{clock(todayRecord?.inTime)}</strong></div><div className="time-divider"/><div><span className="muted">CHECK OUT</span><strong>{clock(todayRecord?.outTime)}</strong></div></div>
        <label className="field-label" htmlFor="attendance-note">Note <span className="muted">(optional)</span></label><textarea id="attendance-note" value={comment} onChange={(e) => setComment(e.target.value)} placeholder="Add a note for today's attendance" rows="3" />
        <button className="button button-primary" disabled={busy || !!todayRecord?.inTime} onClick={() => mark('checkin')}>{busy ? 'Saving…' : todayRecord?.inTime ? 'Checked in for today' : 'Check in'}</button>
        <button className="button button-secondary" disabled={busy || !todayRecord?.inTime || !!todayRecord?.outTime} onClick={() => mark('checkout')}>{todayRecord?.outTime ? 'Day completed' : 'Check out'}</button>
        <p className="helper-copy">Your times are recorded automatically when you mark attendance.</p>
      </article>
      <article className="card history-card"><div className="card-heading"><div><span className="eyebrow">YOUR RECORDS</span><h2>Attendance history</h2></div><button className="button button-light" onClick={refresh}>↻ Refresh</button></div>
        {rows.length === 0 ? <div className="empty-state"><span className="empty-icon">◷</span><strong>No attendance records yet</strong><span>Your check-in will appear here.</span></div> : <div className="table-wrap"><table><thead><tr><th>Date</th><th>Employee</th><th>Check in</th><th>Check out</th><th>Status</th></tr></thead><tbody>{rows.map((row) => <tr key={row.attendanceId}><td>{row.attendancedate}</td><td>{row.employee?.emp_name || user.emp_name}</td><td className="time-in">{clock(row.inTime)}</td><td className={row.outTime ? 'time-out' : ''}>{clock(row.outTime)}</td><td><span className={`status-pill ${row.outTime ? 'pill-green' : row.inTime ? 'pill-blue' : 'pill-amber'}`}>{row.outTime ? 'Completed' : row.inTime ? 'Checked in' : 'Pending'}</span></td></tr>)}</tbody></table></div>}
      </article>
    </section>
    <footer className="page-footer">HRMS <span>·</span> Attendance made simple</footer>
  </main>
}


