package com.example;

class PurchasingAgent implements Runnable {
    @Override
    public void run() {
        purchase();
    }

    private void purchase() {
        Store store = Store.getInstance();

        synchronized (store) {
            System.out.println(Thread.currentThread().getName() + " attempting to purchase...");
            if (store.hasShirts() && store.authorizeCreditCard("1234", 15.00)) {
                String shirt = store.takeShirt();
                if (shirt != null) {
                    System.out.println(Thread.currentThread().getName() + " successfully purchased a " + shirt);
                } else {
                    System.out.println(Thread.currentThread().getName() + " failed to get a shirt.");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " purchase failed.");
            }
        }
    }
}