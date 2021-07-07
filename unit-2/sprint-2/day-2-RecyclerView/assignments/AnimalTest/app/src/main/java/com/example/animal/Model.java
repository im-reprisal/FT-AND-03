package com.example.animal;

public class Model {
    private int pic;
    private String type;
    private String sound;

    public Model(int pic, String type, String sound) {
        this.pic = pic;
        this.type = type;
        this.sound = sound;
    }

    public int getPic() {
        return pic;
    }

    public String getType() {
        return type;
    }

    public String getSound() {
        return sound;
    }
}
