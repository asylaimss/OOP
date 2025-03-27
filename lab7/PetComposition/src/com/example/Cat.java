package com.example;

public class Cat extends Animal implements Pet {
    private Nameable nameable = new NameableImpl();
    private Ambulatory ambulatory = new AmbulatoryImpl(4);

    @Override
    public void eat() {
        System.out.println("Cat is eating.");
    }

    @Override
    public void play() {
        System.out.println("Cat is playing.");
    }

    @Override
    public void setName(String name) {
        nameable.setName(name);
    }

    @Override
    public String getName() {
        return nameable.getName();
    }

    public void walk() {
        ambulatory.walk();
    }
}