package com.suvam.service;

import com.suvam.model.Student;
import com.suvam.util.GradeCalculator;

import java.util.ArrayList;

public class StudentManager {

    // To store total number of students on ArrayList
    private final ArrayList<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    //Add students
    public void addStudent(Student student) {
        students.add(student);
    }

    //View all students
    public void showAllStudents() {
        for (Student s: getStudents()) {
            String grade = GradeCalculator.calculateGrade(s.getMarks());
            System.out.println(s + " -| Grade: " + grade);
        }
    }

    //Display only one topper among the student
    public Student findTopper() {
        if (students.isEmpty()) return null;

        Student topper = students.get(0);

        for (Student student : students) {
            if (student.getMarks() > topper.getMarks()) {
                topper = student;
            }
        }
        return topper;
    }

    // Returns all the students information
    public ArrayList<Student> getStudents() {
        return students;
    }
}
