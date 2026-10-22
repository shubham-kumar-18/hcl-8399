package org.abes.hrms.Repository;

import org.springframework.stereotype.Component;

@Component
public class EmpRepImp implements EmpRepo {
    @Override
    public double squareroot(double a) {
        double result = Math.sqrt(a);
        return result;
    }
    public String empData() {
        return "";
    }
    public int add(int a, int b) {
        int result = a + b;
        return result;
    }
    public int gnt(int a,int b) {
        if(a>b) return a;
        else return b;
    }
}
