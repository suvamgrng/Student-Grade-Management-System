package com.suvam.model;

public class Student {
    private String name;
    private float marks;

    public Student(String name, float marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public float getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "Name: " + name + " - Marks: " + marks;
    }
}
