package com.suvam;

import com.suvam.model.Student;
import com.suvam.service.StudentManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void menuInfo() {
        System.out.println("==============================================================");
        System.out.println("                Student Grade Management System");
        System.out.println("==============================================================");
        System.out.println("1.- Add      ");
        System.out.println("2.- View     ");
        System.out.println("3.- Topper   ");
        System.out.println("4.- Exit     ");
        System.out.println("==============================================================");
    }

    public static void main(String[] args) {
        int digit;
        int stTotal; // Total students
        String name = "";
        float marks = 0.0f;
        String grade;

        // Creating a new instances of the StudentManager class
        StudentManager collectInfo = new StudentManager();
        try (Scanner sc = new Scanner(System.in)) {
            menuInfo(); // Display Main Menu Information
            System.out.print("Enter a number(1-4): ");
            digit = sc.nextInt();

            while (true) {


                switch (digit) {

                    case 1:
                        System.out.print("Enter total students of the class: ");
                        stTotal = sc.nextInt();
                        sc.nextLine();

                        for (int i = 0; i < stTotal; i++) {
                            System.out.print("Enter student name " + (i + 1) + ": ");
                            name = sc.nextLine();


                            if (name.trim().isEmpty()) {
                                System.out.println("Invalid. Enter a name ");

                            }

                            System.out.print("Enter students marks " + (i + 1) + ": ");
                            marks = sc.nextFloat();
                            sc.nextLine();

                            if (marks < 0 || marks > 100) {
                                System.out.println("Invalid. Enter a marks");
                            } else {
                                collectInfo.addStudent(new Student(name, marks));
                            }

                        }
                        break;

                    case 2:
                        collectInfo.showAllStudents();
                        break;

                    case 3:
                        Student topper = collectInfo.findTopper();

                        if (topper != null) {
                            System.out.println("Topper: " + topper);
                        } else {
                            System.out.println("No student available");
                        }
                        break;

                    case 4:
                        System.out.println("Thank you for visiting");
                        return;

                    default:
                        System.out.println("Invalid choice. Enter number between 1-3");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a number not strings");
        }
    }
}
