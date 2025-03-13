package com.example;

// Внешний класс
public class OuterClass {

    // Вложенный статический класс
    static class StaticNestedClass {
        void display() {
            System.out.println("Static Nested Class");
        }
    }

    // Внутренний класс-член
    class InnerClass {
        void display() {
            System.out.println("Inner Class");
        }
    }

    // Метод с локальным внутренним классом
    void localClassMethod() {
        class LocalClass {
            void display() {
                System.out.println("Local Inner Class");
            }
        }
        LocalClass local = new LocalClass();
        local.display();
    }

    // Метод с анонимным классом
    void anonymousClassMethod() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous Inner Class");
            }
        };
        runnable.run();
    }

    public static void main(String[] args) {
        // Вложенный статический класс
        StaticNestedClass staticNested = new StaticNestedClass();
        staticNested.display();

        // Внутренний класс-член
        OuterClass outer = new OuterClass();
        InnerClass inner = outer.new InnerClass();
        inner.display();

        // Локальный класс
        outer.localClassMethod();

        // Анонимный класс
        outer.anonymousClassMethod();
    }
}