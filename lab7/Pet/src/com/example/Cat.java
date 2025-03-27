package com.example;

public class Cat extends Animal implements Pet {
    private String name;

    public Cat() {
        this("Fluffy");  // Имя по умолчанию
    }

    public Cat(String name) {
        super(4);  // Возраст 4 года
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println(name + " likes to play with string.");
    }

    @Override
    public void eat() {
        System.out.println("Cats like to eat spiders and fish.");
    }

    @Override
    public void walk() {
        super.walk();  // Вызов метода walk() родительского класса
        System.out.println("Cat walks gracefully.");
    }
}