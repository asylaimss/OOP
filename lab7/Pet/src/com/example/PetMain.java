package com.example;

public class PetMain {
    public static void main(String[] args) {
        // Создание объектов Fish и Cat
        Fish fish = new Fish();
        fish.setName("Goldie");
        Cat cat = new Cat("Mittens");

        // Тестируем различные конструкторы и методы
        Pet petFish = new Fish();
        Pet petCat = new Cat("Whiskers");

        // Вызов методов для Fish
        petFish.play();
        petFish.eat();
        petFish.walk();

        // Вызов методов для Cat
        petCat.play();
        petCat.eat();
        petCat.walk();

        // Вызов метода playWithAnimal
        playWithAnimal(fish);
        playWithAnimal(cat);
    }

    public static void playWithAnimal(Animal a) {
        if (a instanceof Pet) {
            Pet pet = (Pet) a;
            pet.play();
        } else {
            System.out.println("Danger! Wild Animal");
        }
    }
}