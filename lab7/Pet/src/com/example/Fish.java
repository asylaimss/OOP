package com.example;

public class Fish extends Animal implements Pet {
    private String name;

    public Fish() {
        super(0);  // Возраст 0
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Just keep swimming.");
    }

    @Override
    public void eat() {
        System.out.println("Fish eat pond scum.");
    }

    @Override
    public void walk() {
        super.walk();  // Вызов метода walk() родительского класса
        System.out.println("Fish, of course, can't walk; they swim.");
    }
}