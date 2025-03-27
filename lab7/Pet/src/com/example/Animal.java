package com.example;

public abstract class Animal {
    private int age;

    public Animal(int age) {
        this.age = age;
    }

    public void walk() {
        System.out.println("Animal walks.");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}