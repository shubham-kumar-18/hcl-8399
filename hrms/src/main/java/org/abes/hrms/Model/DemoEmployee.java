package org.abes.hrms.Model;



import org.abes.hrms.Repository.EmpRepImp;
import org.abes.hrms.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DemoEmployee {
    @Autowired
    private EmpRepImp emprepo;
    public int add(int a,int b){
        return emprepo.add(10,10);
    }

    public double squareroot(double a){
        return emprepo.squareroot(2000);
    }

    public int gnt(int a,int b){
        return emprepo.gnt(10,20);
    }






}
