package com.example;

import java.util.List;

public class Lion {

    public boolean hasMane;
    Feline feline;


    public Lion(String sex, Feline feline) throws Exception {
        this.feline = feline;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    //Feline feline = new Feline();

    public int getKittens() {
        return feline.getKittens();
        //return 0;
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return feline.getFood("Хищник");
        //return List.of();
    }
}
