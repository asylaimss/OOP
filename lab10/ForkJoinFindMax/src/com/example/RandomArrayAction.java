package com.example;

import java.util.concurrent.RecursiveAction;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayAction extends RecursiveAction {
    private int[] data;
    private int start, end, threshold;

    public RandomArrayAction(int[] data, int start, int end, int threshold) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected void compute() {
        if (end - start <= threshold) {
            for (int i = start; i < end; i++) {
                data[i] = ThreadLocalRandom.current().nextInt(0, 1000);
            }
        } else {
            int mid = (start + end) / 2;
            RandomArrayAction left = new RandomArrayAction(data, start, mid, threshold);
            RandomArrayAction right = new RandomArrayAction(data, mid, end, threshold);
            invokeAll(left, right);
        }
    }
}