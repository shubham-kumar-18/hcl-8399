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
    public String deleteById(int emp_id) {
        return "";
    }

    @Override
    public String updateById(int emp_id, Employee updateEmp) {
        return "";
    }

}
