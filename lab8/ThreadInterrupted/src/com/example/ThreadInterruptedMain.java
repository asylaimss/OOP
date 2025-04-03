package com.example;

import java.util.Scanner;

public class ThreadInterruptedMain {
    public static void main(String[] args) {
        Counter counter = new Counter();  // Создание объекта Counter
        Thread counterThread = new Thread(counter);  // Создание потока с объектом Counter
        counterThread.start();  // Запуск потока

        // Ожидание нажатия Enter для прерывания потока
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to stop the counter...");
        scanner.nextLine();  // Блокируем поток, пока не нажмут Enter

        System.out.println("Interrupting the thread...");
        counterThread.interrupt();  // Прерывание потока

        try {
            Thread.sleep(1000);  // Ожидание 1 секунду для завершения потока
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Печать состояния потока после прерывания
        if (counterThread.isAlive()) {
            System.out.println("Thread is still alive.");
        } else {
            System.out.println("Thread has finished.");
        }

        scanner.close();  // Закрытие сканнера
    }
}