package com.example.task4.model;

public class Student {
    private int StudentID;
    private String StudentName;
    private  int Age;
    public Student(int StudentID, String StudentName, int Age) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.Age = Age;
    }
    public Student() {

    }
    public int getStudentID() {
        return StudentID;
    }
    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }
    public String getStudentName() {
        return StudentName;
    }
    public void setStudentName(String StudentName) {
        this.StudentName = StudentName;
    }
    public int getAge() {
        return Age;
    }
    public void setAge(int Age) {
        this.Age = Age;
    }
}
