package org.jhon.jenkins.test;

import java.util.List;

public class University {
    private String name;
    private List<Teacher> teachers;
    private List<Class> classes;
    private List<Student> students;

    public University(String name, List<Teacher> teachers, List<Class> classes, List<Student> students) {
        this.name = name;
        this.teachers = teachers;
        this.classes = classes;
        this.students = students;
    }


    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
