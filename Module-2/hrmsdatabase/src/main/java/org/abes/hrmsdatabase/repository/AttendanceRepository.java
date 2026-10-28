package org.abes.hrmsdatabase.repository;

import org.abes.hrmsdatabase.Model.Attendance;
import org.abes.hrmsdatabase.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    boolean existsByEmployeeAndAttendancedate(Employee employee, LocalDate attendancedate);
    Optional<Attendance> findByEmployeeAndAttendancedate(Employee employee, LocalDate attendancedate);
    @Query("select a from attendance a where a.employee.emp_id = :empId order by a.attendancedate desc")
    List<Attendance> findAttendanceForEmployee(@Param("empId") long empId);
}
