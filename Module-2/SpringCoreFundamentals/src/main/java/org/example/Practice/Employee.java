package org.example.Practice;

public class Employee {
    private Address address;
    private Salary salary;
    private Department department;
    private int id;
    private String name;
    public Employee(Address address, Salary salary, Department department, int id, String name) {
        this.address = address;
        this.salary = salary;
        this.department = department;
        this.id = id;
        this.name = name;
    }

    public void getSalary(){
        salary.getSalary();
    }
    public void getDepartment(){
        department.getDepartment();
    }
    public void getAddress(){
        address.getAddress();

    }
}
