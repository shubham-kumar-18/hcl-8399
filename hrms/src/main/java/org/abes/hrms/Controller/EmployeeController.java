package org.abes.hrms.Controller;

import org.abes.hrms.Model.DemoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private DemoEmployee demoEmployee;


    @GetMapping("/")
    public String home() {
        return "Home page";
    }

    @GetMapping("/add")
    public int sum() {
        System.out.println("helllooooooooo");
        int result = demoEmployee.add(10,5);
        return result;
    }

    @GetMapping("/squareroot")
    public double squareroot() {
        return demoEmployee.squareroot(2000);
    }

    @GetMapping("/gnot")
    public int gnt() {
        return demoEmployee.gnt(10,20);
    }

}