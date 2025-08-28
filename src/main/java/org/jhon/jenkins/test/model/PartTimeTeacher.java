package org.jhon.jenkins.test.model;

public class PartTimeTeacher extends Teacher {
    private final int hoursPerWeek;

    public PartTimeTeacher(String name, double baseSalary, int hoursPerWeek) {
        super(name, baseSalary);
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() * hoursPerWeek;
    }

    @Override
    public String toString() {
        return "PartTimeTeacher{name='" + getName() + "', baseSalary=" + getBaseSalary() + ", Salary=" + calculateSalary() + ", hoursPerWeek=" + hoursPerWeek + "}";
    }
}
