package org.abes.hclhrms;

import org.abes.hclhrms.Repository.EmpRepoImp;
import org.abes.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {

    @Autowired
    private EmpRepoImp emprepo;
    Employee emp2= new Employee(101,"Shubham","Engineer","Developer","sstm@gmail.com");
    public String addEmp(){
        Employee emp1 = new Employee(101,"Shubham","Engineer","Developer","sstm@gmail.com");
        return emprepo.addemp(emp1);

    }
    public List<Employee> getemp() {
        return emprepo.getemp();
    }

    public Employee getEmpById() {
        return emprepo.getEmpById(101);
    }

   public String addEmpBulk() {
        return emprepo.addEmpbulk();
   }
   public String deleteById(){
        return emprepo.deleteById(101);
   }


    public String updateById() {
        return emprepo.updateById(101,emp2);
    }

}
