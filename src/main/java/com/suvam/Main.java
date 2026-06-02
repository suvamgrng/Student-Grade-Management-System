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
        String input;
        String nameInput;
        String marksInput;
        int stTotal; // Total students
        String name = "";
        float marks = 0.0f;
        String grade;

        // Creating a new instances of the StudentManager class
        StudentManager collectInfo = new StudentManager();

        try (Scanner sc = new Scanner(System.in)) {
            menuInfo(); // Display Main Menu Information

            while (true) {
                System.out.print("Enter a number(1-4): ");
                input = sc.nextLine().trim();

                // Check for empty input safely
                if (input.isEmpty()) {
                    System.out.println("Empty input. Please enter something.\n");
                    continue; // Skips the current iteration
                }

                try {
                    digit = Integer.parseInt(input); // Converting string number .i.e "5" into int type 5.
                } catch (NumberFormatException e) {
                    System.out.println("Error. Please enter a valid number, not characters.\n");
                    continue; // Skips the current iteration
                }

                // Check range (1 to 4)
                if (digit < 1 || digit > 4) { // Enter valid number between 1 and 4 otherwise will get this error message.
                    System.out.println("Invalid input. Enter number between(1-4)\n");
                    continue; // Skips the current iteration
                }

                switch (digit) {
                    case 1:
                        while (true) {
                            System.out.print("Enter total students of the class: ");
                            nameInput = sc.nextLine().trim();

                            if (nameInput.isEmpty()) {
                                System.out.println("Empty input! Enter student name.\n");
                            } else {
                                try {
                                    stTotal = Integer.parseInt(nameInput);
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("Error. Enter a number instead of strings.\n");
                                }
                            }
                        }

                        for (int i = 0; i < stTotal; i++) {
                            // Inner loop: keeps asking until a valid name is entered
                            while (true) {
                                System.out.print("Enter student name: ");
                                name = sc.nextLine();

                                if (name.trim().isEmpty()) {
                                    System.out.println("Invalid! Enter a name.\n");
                                } else {
                                    break; // Valid name — exit the inner loop
                                }
                            }

                            while (true) {
                                System.out.print("Enter students marks " + (i + 1) + ": ");
                                marksInput = sc.nextLine().trim();

                                try {
                                    marks = Float.parseFloat(marksInput);
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid. Enter a numeric value for marks.");
                                }

                                if (marks < 0 || marks > 100) {
                                    System.out.println("Invalid. Enter a marks");
                                } else {
                                    collectInfo.addStudent(new Student(name, marks));
                                    break;
                                }
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
