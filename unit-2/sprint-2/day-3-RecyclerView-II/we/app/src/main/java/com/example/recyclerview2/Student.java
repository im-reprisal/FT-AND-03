package com.example.recyclerview2;

public class Student {
    private String name;
    private String dob;
    private int  age;
    private String address;
    private int image;

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getImage() {
        return image;
    }

    public Student(String name, String dob, int age, String address, int image) {
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.address = address;
        this.image = image;
    }
}