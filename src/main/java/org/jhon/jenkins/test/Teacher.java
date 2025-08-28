package org.jhon.jenkins.test;

public abstract class Teacher {
    private String name;
    private double baseSalary;

    public Teacher(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract double calculateSalary ();

    public String toString() {
        return "Teacher{name='" + name + "', baseSalary=" + baseSalary + "}";
    }
}