package com.example;

public class Counter implements Runnable {
    @Override
    public void run() {
        int x = 0;

        while (!Thread.currentThread().isInterrupted()) {
            try {
                System.out.println(x);  // Печать текущего значения x
                x++;  // Увеличение значения
                Thread.sleep(1000);  // Задержка на 1 секунду
            } catch (InterruptedException e) {
                // Прерывание потока
                System.out.println("Thread interrupted");
                return;  // Выход из метода, если поток был прерван
            }
        }
    }
}