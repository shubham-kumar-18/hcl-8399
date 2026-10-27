import { useState } from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'
import SampleCode from './Component/SampleCode'
import UseFetchApi from './Component/UseFetchApi'
import { BrowserRouter, Route } from 'react-router-dom';
import Home from './Component/Home'
import Login from './Component/Login'
import Registration from './Component/Registration'
import Dashboard from './Component/Dashboard'
import { Routes } from 'react-router-dom'
function App() {
  


  return (
   <div>
     <BrowserRouter>
         <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/registration" element={<Registration />} />
            <Route path="/dashboard" element={<Dashboard />} />
         </Routes>
     
     </BrowserRouter>






   </div>
    

  )
}

export default App
