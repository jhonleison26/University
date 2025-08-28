package org.jhon.jenkins.test;

public class PartTimeTeacher extends Teacher{
    private final int hoursPerWeek;

    public PartTimeTeacher(String name, double baseSalary, int hoursPerWeek) {
        super(name, baseSalary);
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() * hoursPerWeek;
    }

    public String toString() {
        return "PartTimeTeacher{name='" + getName() + "', baseSalary=" + getBaseSalary() + ", hoursPerWeek=" + hoursPerWeek + "}";
    }
}
