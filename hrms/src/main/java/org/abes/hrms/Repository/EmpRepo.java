package org.abes.hrms.Repository;


import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo {
    double squareroot(double a);
    String empData();
    public int add(int a, int b);
    int gnt(int a,int b);

}
