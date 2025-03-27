package com.example;

public class Fish extends Animal implements Pet {
    private Nameable nameable = new NameableImpl();

    @Override
    public void eat() {
        System.out.println("Fish is eating.");
    }

    @Override
    public void play() {
        System.out.println("Fish is playing.");
    }

    @Override
    public void setName(String name) {
        nameable.setName(name);
    }

    @Override
    public String getName() {
        return nameable.getName();
    }
}