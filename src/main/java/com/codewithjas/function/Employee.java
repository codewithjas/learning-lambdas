package com.codewithjas.function;

public class Employee {
    String ename;
    int salary;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String ename, int salary) {
        this.ename = ename;
        this.salary = salary;
    }
}
