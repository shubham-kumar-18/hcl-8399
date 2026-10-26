package org.abes.hrmsdatabase.controller;


import org.abes.hrmsdatabase.Model.Employee;
import org.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/")
    public String msg()
    {
        return "<h2> Welcome to SpringBoot Development</h2>";
    }
    @GetMapping("/new")
    public String addnewEmployee(){
        return employeeService.createnewEmployee();

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


}
