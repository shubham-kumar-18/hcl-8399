package org.abes.hrmsdatabase.service;

import org.abes.hrmsdatabase.Model.Employee;
import org.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public String createnewEmployee() {
        Employee emp1 = new Employee(101l, "Shubham", "Java Fsd", "Developer");
        employeeRepository.save(emp1);
        return "Employee Created Successfully";
    }

    public Employee getEmployeeById(long emp_id) {
        return employeeRepository.findById(emp_id).orElse(null);
    }

    public String deleteEmployeeById(long emp_id) {
        if(employeeRepository.existsById(emp_id)) {
            employeeRepository.deleteById(emp_id);
        }
        return "Employee Deleted Successfully";
    }
    public String updateEmployee(@PathVariable long emp_id) {
        Employee emp = employeeRepository.findById(emp_id).orElse(null);
        if(emp != null) {
            Employee emp2 = new Employee(emp_id, "Sameer", "Java Fsd", "Developer");

            employeeRepository.save(emp2);
        }
        return "Employee Updated Successfully";
    }

}
