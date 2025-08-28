package org.jhon.jenkins.test;

import java.util.List;

public class Class {
    private String name;
    private Teacher teacher;
    private String classRoom;
    private List<Student> students;

    public Class(String className, Teacher teacher, String classRoom, List<Student> students) {
        this.name = className;
        this.teacher = teacher;
        this.classRoom = classRoom;
        this.students = students;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String toString() {
        return "Class{name='" + name + "', teacher=" + teacher + ", classRoom='" + classRoom + "', students=" + students + "}";
    }
}
