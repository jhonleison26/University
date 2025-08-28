package org.jhon.jenkins.test.Menu;

import org.jhon.jenkins.test.data.University;
import org.jhon.jenkins.test.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversityApp {
    University university = new University("Global University", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    Scanner sc = new Scanner(System.in);

    private void initializeData() {
        // Teachers
        FullTimeTeacher silvana = new FullTimeTeacher("Silvana", 1300, 5);
        FullTimeTeacher juanse = new FullTimeTeacher("Juan Sebastián", 1200, 3);
        PartTimeTeacher juanca = new PartTimeTeacher("Juan Carlos", 50, 20);
        PartTimeTeacher lorena = new PartTimeTeacher("Lorena", 60, 15);

        university.addTeacher(silvana);
        university.addTeacher(juanse);
        university.addTeacher(juanca);
        university.addTeacher(lorena);

        // Students
        Student carlos = new Student("Carlos", "S001", 20);
        Student juanes = new Student("Juanes", "S002", 22);
        Student valentina = new Student("Valentina", "S003", 21);
        Student jhon = new Student("Jhon", "S004", 20);
        Student diego = new Student("Diego", "S005", 20);
        Student franyelica = new Student("Franyelica", "S006", 20);
        Student santiago = new Student("Santiago", "S007", 21);
        Student laura = new Student("Laura", "S008", 19);

        university.addStudent(carlos);
        university.addStudent(juanes);
        university.addStudent(valentina);
        university.addStudent(jhon);
        university.addStudent(diego);
        university.addStudent(franyelica);
        university.addStudent(santiago);
        university.addStudent(laura);

        // Classes
        Course javaBasics = new Course("Java Basics", silvana, "A1",
                new ArrayList<>(List.of(carlos, juanes, valentina)));

        Course testAutomation = new Course("Test Automation", juanse, "B1",
                new ArrayList<>(List.of(jhon, diego, franyelica)));

        Course tcDesign = new Course("TC Design", juanca, "C1",
                new ArrayList<>(List.of(carlos, jhon, diego)));

        Course apis = new Course("APIs", lorena, "D1",
                new ArrayList<>(List.of(juanes, valentina, franyelica)));

        university.addCourse(javaBasics);
        university.addCourse(testAutomation);
        university.addCourse(tcDesign);
        university.addCourse(apis);
    }

    private void listTeachers() {
        for (Teacher t : university.getTeachers()) {
            System.out.println(t);
        }
    }

    private void listClasses() {
        for (int i = 0; i < university.getClasses().size(); i++) {
            System.out.println((i + 1) + ". " + university.getClasses().get(i).getName());
        }
        System.out.print("Select a class number to see details: ");
        int option = sc.nextInt() - 1;
        if (option >= 0 && option < university.getClasses().size()) {
            Course c = university.getClasses().get(option);
            System.out.println("Class: " + c.getName());
            System.out.println("Teacher: " + c.getTeacher());
            System.out.println("Students:");
            for (Student s : c.getStudents()) {
                System.out.println("  - " + s);
            }
        } else {
            System.out.println("Invalid option.");
        }
    }

    private void createStudent() {
        System.out.print("Enter student name: ");
        String name = sc.next();
        System.out.print("Enter student ID: ");
        String id = sc.next();
        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        Student newStudent = new Student(name, id, age);
        university.addStudent(newStudent);
        System.out.println("Student added: " + newStudent);

        System.out.println("Select a class to enroll the student:");
        for (int i = 0; i < university.getClasses().size(); i++)
            System.out.println((i + 1) + ". " + university.getClasses().get(i).getName());
        int classOption = sc.nextInt() - 1;
        if (classOption >= 0 && classOption < university.getClasses().size()) {
            university.getClasses().get(classOption).addStudent(newStudent);
            System.out.println("Student " + newStudent.getName() + " enrolled in " +
                    university.getClasses().get(classOption).getName());
        } else {
            System.out.println("Invalid class option.");
        }
    }

    private void createClass() {
        System.out.print("Enter class name: ");
        String className = sc.next();
        System.out.print("Enter class code: ");
        String code = sc.next();

        // select teacher
        System.out.println("Select a teacher:");
        for (int i = 0; i < university.getTeachers().size(); i++) {
            System.out.println((i + 1) + ". " + university.getTeachers().get(i).getName());
        }
        int teacherOption = sc.nextInt() - 1;
        if (teacherOption < 0 || teacherOption >= university.getTeachers().size()) {
            System.out.println("Invalid teacher option.");
            return;
        }
        Teacher teacher = university.getTeachers().get(teacherOption);

        // select students
        List<Student> selectedStudents = new ArrayList<>();
        System.out.println("Select students (enter 0 to finish):");
        for (int i = 0; i < university.getStudents().size(); i++) {
            System.out.println((i + 1) + ". " + university.getStudents().get(i).getName());
        }
        int studentOption;
        do {
            studentOption = sc.nextInt();
            if (studentOption > 0 && studentOption <= university.getStudents().size()) {
                selectedStudents.add(university.getStudents().get(studentOption - 1));
            }
        } while (studentOption != 0);

        Course newCourse = new Course(className, teacher, code, selectedStudents);
        university.addCourse(newCourse);
        System.out.println("Class created: " + newCourse);
    }

    private void listStudentClasses() {
        System.out.print("Enter student ID: ");
        String id = sc.next();
        Student student = university.getStudents().stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("Classes for student " + student.getName() + ":");
        for (Course c : university.getClasses()) {
            if (c.getStudents().contains(student)) {
                System.out.println(" - " + c.getName() + " (" + c.getClassRoom() + ")");
            }
        }
    }

    public void menu() {
        initializeData();
        int option = 0;
        do {
            System.out.println("");
            System.out.println("----- University Management System -----");
            System.out.println("1. List Teachers");
            System.out.println("2. List Classes (with details)");
            System.out.println("3. Create new student and enroll in class");
            System.out.println("4. Create new class");
            System.out.println("5. List a student's classes");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            option = sc.nextInt();
            switch (option) {
                case 1 -> listTeachers();
                case 2 -> listClasses();
                case 3 -> createStudent();
                case 4 -> createClass();
                case 5 -> listStudentClasses();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option. Please try again.");
            }
        } while (option != 6);
    }
}
