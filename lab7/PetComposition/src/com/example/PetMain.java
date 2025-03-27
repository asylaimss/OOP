package com.example;

public class PetMain {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Whiskers");
        System.out.println("Cat's name: " + cat.getName());
        cat.play();
        cat.walk();

        Fish fish = new Fish();
        fish.setName("Nemo");
        System.out.println("Fish's name: " + fish.getName());
        fish.play();

        Spider spider = new Spider();
        spider.walk();
    }
}