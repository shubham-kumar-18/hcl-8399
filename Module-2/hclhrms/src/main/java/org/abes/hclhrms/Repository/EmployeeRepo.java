package org.abes.hclhrms.Repository;


import org.abes.hclhrms.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo {
    String addemp(Employee emp);

    Employee getEmpById(int emp_id);
    String deleteById(int emp_id);
    String updateById(int emp_id,Employee updateEmp);
    List<Employee> getemp();
}
