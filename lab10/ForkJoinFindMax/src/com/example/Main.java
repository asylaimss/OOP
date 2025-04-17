package com.example;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int[] data = new int[1000000];
        int threshold = 10000;

        ForkJoinPool pool = new ForkJoinPool();

        // Старый способ инициализации — закомментируй
        /*
        for (int i = 0; i < data.length; i++) {
            data[i] = (int)(Math.random() * 1000);
        }
        */

        // Новый способ с использованием ForkJoin
        RandomArrayAction action = new RandomArrayAction(data, 0, data.length, threshold);
        pool.invoke(action);

        // Теперь ищем максимум
        FindMaxTask task = new FindMaxTask(data, 0, data.length, threshold);
        int max = pool.invoke(task);

        System.out.println("Maximum value found: " + max);
    }
}