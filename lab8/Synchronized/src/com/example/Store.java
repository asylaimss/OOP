package com.example;

class Store {
    private static Store instance;
    private int shirts = 1;

    private Store() {}

    public static synchronized Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }
        return instance;
    }

    public synchronized boolean authorizeCreditCard(String cardNumber, double amount) {
        try {
            int delay = (int) (Math.random() * 3 + 1) * 1000;
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return true;
    }

    public synchronized boolean hasShirts() {
        return shirts > 0;
    }

    public synchronized String takeShirt() {
        if (shirts > 0) {
            shirts--;
            return "Shirt";
        }
        return null;
    }
}
