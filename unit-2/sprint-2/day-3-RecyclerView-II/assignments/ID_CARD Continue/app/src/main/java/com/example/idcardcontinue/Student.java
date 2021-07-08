package com.example.idcardcontinue;

public class Student {
    private String companyName;
    private int  age;
    private String profession;
    private int image;

    public Student(String companyName, int age, String profession, int image) {
        this.companyName = companyName;
        this.age = age;
        this.profession = profession;
        this.image = image;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getAge() {
        return age;
    }

    public String getProfession() {
        return profession;
    }

    public int getImage() {
        return image;
    }
}