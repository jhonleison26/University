package org.jhon.jenkins.test.data;

import org.jhon.jenkins.test.model.Class;
import org.jhon.jenkins.test.model.Student;
import org.jhon.jenkins.test.model.Teacher;

import java.util.List;

public class University {
    private String name;
    private List<Teacher> teachers;
    private List<org.jhon.jenkins.test.model.Class> classes;
    private List<Student> students;

    public University(String name, List<Teacher> teachers, List<org.jhon.jenkins.test.model.Class> classes, List<Student> students) {
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

    public List<org.jhon.jenkins.test.model.Class> getClasses() {
        return classes;
    }

    public void setClasses(List<org.jhon.jenkins.test.model.Class> classes) {
        this.classes = classes;
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

    public void addClass(Class newClass) {
        this.classes.add(newClass);
    }

    public String toString() {
        return "University{name='" + name + "', teachers=" + teachers + ", classes=" + classes + ", students=" + students + "}";
    }

}
