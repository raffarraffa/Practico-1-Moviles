package com.rafalopez.practico_1;

import androidx.annotation.NonNull;

public class Palabra {
    private String eng;
    private String esp;
    private String img;

    public Palabra(String eng, String esp, String img) {
        this.eng = eng;
        this.esp = esp;
        this.img = img;
    }
    public Palabra(String eng, String esp) {
        this.eng = eng;
        this.esp = esp;
        this.img = "no_image.png";
    }

    public String getEng() {
        return eng;
    }

    public String getEsp() {
        return esp;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    @NonNull
    @Override
    public String toString() {
        return "Palabra{" +
                "ingles='" + eng + '\'' +
                ", español='" + esp + '\'' +
                ", imagen='" + img + '\'' +
                '}';
    }

}
