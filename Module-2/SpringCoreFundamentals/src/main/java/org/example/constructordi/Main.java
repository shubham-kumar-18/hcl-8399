package org.example.constructordi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(org.example.Practice.AppConfig.class);
        org.example.constructordi.Employee emp =ctx.getBean(org.example.constructordi.Employee.class);
        emp.getEmpAddress();
    }

}
