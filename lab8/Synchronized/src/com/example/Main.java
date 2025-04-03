package com.example;

public class Main {
    public static void main(String[] args) {
        Thread agent1 = new Thread(new PurchasingAgent(), "Agent-1");
        Thread agent2 = new Thread(new PurchasingAgent(), "Agent-2");

        agent1.start();
        agent2.start();
    }
}