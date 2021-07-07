package com.example.idenditycard;

public class Model {
    private int pic;
    private String name;
    private int age;
    private String work;

    public Model(int pic, String name, int age, String work) {
        this.pic = pic;
        this.name = name;
        this.age = age;
        this.work = work;
    }

    public int getPic() {
        return pic;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getWork() {
        return work;
    }
}
