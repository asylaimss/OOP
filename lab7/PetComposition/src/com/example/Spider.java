package com.example;

public class Spider extends Animal implements Ambulatory {
    private Ambulatory ambulatory = new AmbulatoryImpl(8);

    @Override
    public void eat() {
        System.out.println("Spider is eating.");
    }

    @Override
    public void walk() {
        ambulatory.walk();
    }
}