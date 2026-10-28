package org.abes.hrmsdatabase.controller;


import org.abes.hrmsdatabase.Model.Employee;
import org.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/v1/user")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String msg()
    {
        return "<h2> Welcome to SpringBoot Development</h2>";
    }
    @PostMapping ("/addemp")
    public String addnewEmployee(@RequestBody Employee emp){
        System.out.println(emp.getEmpEmail());
        return employeeService.createnewEmployee(emp);

    }
    @GetMapping("/addid/{emp_id}")
    public Employee getEmployeeById(@PathVariable long emp_id)
    {
        System.out.println("EmployeeId:"+emp_id);
        return employeeService.getEmployeeById(emp_id);
    }
    @DeleteMapping("/deleteid/{emp_id}")
    public  String deleteEmployee(@PathVariable long emp_id)
    {
        System.out.println("EmployeeId:"+emp_id);
        return employeeService.deleteEmployeeById(emp_id);
    }
    @PutMapping("/updateid/{emp_id}")
    public String updateEmployee(@PathVariable long emp_id)
    {
        return employeeService.updateEmployee(emp_id);
    }



   @PostMapping("/login")
   public String login(@RequestBody Employee employee) {
       return employeeService.verification(
               employee.getEmp_id(),
               employee.getEmpPassword()
       );
   }



}

