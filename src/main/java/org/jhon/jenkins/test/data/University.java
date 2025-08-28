package org.jhon.jenkins.test.data;

import org.jhon.jenkins.test.model.Course;
import org.jhon.jenkins.test.model.Student;
import org.jhon.jenkins.test.model.Teacher;

import java.util.List;

public class University {
    private String name;
    private List<Teacher> teachers;
    private List<Course> courses;
    private List<Student> students;

    public University(String name, List<Teacher> teachers, List<Course> courses, List<Student> students) {
        this.name = name;
        this.teachers = teachers;
        this.courses = courses;
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

    public List<Course> getClasses() {
        return courses;
    }

    public void setClasses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void addCourse(Course newCourse) {
        this.courses.add(newCourse);
    }

    public String toString() {
        return "University{name='" + name + "', teachers=" + teachers + ", classes=" + courses + ", students=" + students + "}";
    }

}
