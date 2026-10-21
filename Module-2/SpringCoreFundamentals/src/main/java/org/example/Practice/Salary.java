package org.example.Practice;

public class Salary {
    private int basic;
    private int bonus;
    private int DA;

    public  Salary(int basic, int bonus, int DA)
    {
        this.basic=basic;
        this.bonus=bonus;
        this.DA=DA;
    }
    void getSalary()
    {
        System.out.println("basic:"+basic + " bonus:"+bonus+" DA:"+DA);
    }
}
