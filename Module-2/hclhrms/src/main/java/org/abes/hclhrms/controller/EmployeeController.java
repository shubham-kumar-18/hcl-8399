package org.abes.hclhrms.controller;


import org.abes.hclhrms.EmployeeServiceImp;
import org.abes.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp empservice;
    @GetMapping("/")
    public  String welcomemsg(){
        return "Welcome Employee!";
    }

    @GetMapping("/addemp")
    public String addnewEmployee(){
        return empservice.addEmp();

    }
    @GetMapping("/getemp")
    public List<Employee>  getemp(){
        return empservice.getemp();
    }
    @GetMapping("/id")
    public Employee getempById(){
        return empservice.getEmpById();
    }


}
