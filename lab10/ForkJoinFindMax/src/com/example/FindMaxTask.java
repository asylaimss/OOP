package com.example;

import java.util.concurrent.RecursiveTask;

public class FindMaxTask extends RecursiveTask<Integer> {
    private int[] data;
    private int start, end, threshold;

    public FindMaxTask(int[] data, int start, int end, int threshold) {
        this.data = data;
        this.start = start;
        this.end = end;
        this.threshold = threshold;
    }

    @Override
    protected Integer compute() {
        if (end - start <= threshold) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i < end; i++) {
                if (data[i] > max) {
                    max = data[i];
                }
            }
            return max;
        } else {
            int mid = (start + end) / 2;
            FindMaxTask left = new FindMaxTask(data, start, mid, threshold);
            FindMaxTask right = new FindMaxTask(data, mid, end, threshold);
            invokeAll(left, right);
            return Math.max(left.join(), right.join());
        }
    }
}