package org.example.Practice;

public class Department {
    private String dep_name;
    private int dep_id;
    public Department(String dep_name, int dep_id) {
        this.dep_name = dep_name;
        this.dep_id = dep_id;
    }
    void getDepartment(){
        System.out.println(dep_name + " " + dep_id);
    }
}
