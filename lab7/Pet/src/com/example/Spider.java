package com.example;

public class Spider extends Animal {

    public Spider() {
        super(2); // Пример возраста
    }

    @Override
    public void walk() {
        System.out.println("Spider walks with 8 legs.");
    }
}