package org.abes.hclhrms.Repository;


import org.abes.hclhrms.entity.Employee;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository

public class EmpRepoImp implements EmployeeRepo {

    List<Employee> empList=new ArrayList<>();
    @Override
    public String addemp(Employee emp) {
        empList.add(emp);
        return "Employee Added Successfully";
    }

    @Override
    public List<Employee> getemp() {
        return empList;
    }

    @Override
    public Employee getEmpById(int emp_id) {
        return empList.stream().filter(e->e.getEmp_id()==emp_id).findFirst().orElse(null);
    }





    @Override
    public String addEmpbulk() {
        List<Employee> bulkEmployees = List.of(
                new Employee(100, "Ankush", "Student", "FSD", "ankush7380@gmail.com"),
                new Employee(101, "Ashish", "Developer", "Java", "ashish@gmail.com"),
                new Employee(102, "Amitabh", "Tester", "java", "abhay@gmail.com"),
                new Employee(103, "Isahan", "FSD", "Java", "ishan@gmail.com")
        );
        empList.addAll(bulkEmployees);
        return bulkEmployees.size() + " employees added successfully";
    }
    @Override
    public String deleteById(int emp_id) {
        boolean status = false;
        if (getEmpById(emp_id) != null){
            status = empList.removeIf(e->e.getEmp_id()==emp_id);
        }
        if (status){
            return "Employee Deleted Successfully";
        }
        return "Employee is not Registered with id" + emp_id;
    }
    public String updateById(int emp_id,Employee updateEmp)
    {
        Employee exist = getEmpById(emp_id);
        if(exist!=null){
            exist.setEmail("xyz@gmail.com");
        }
        return "Employee Updated Successfully";
    }


}
