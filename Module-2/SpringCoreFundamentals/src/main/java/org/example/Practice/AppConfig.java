package org.example.Practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AppConfig {
   @Bean
    public Address getAddress(){
       return new Address("Crossing Republik",201016);
   }
   @Bean
    public Department getDepartment(){
       return new Department("IT",201);
   }
   @Bean
    public Salary getSalary(){
       return new Salary(40000,10000,100000);
   }
   @Bean
    public Employee getEmployee(){
       return new Employee(getAddress(),getSalary(),getDepartment(),101,"Shubham");
   }
}
