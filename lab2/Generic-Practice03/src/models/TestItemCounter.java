package models;

import java.util.*;

public class TestItemCounter {
    public static void main(String[] args) {
        Map<String, Shirt> polos = new HashMap<>();
        polos.put("P001", new Shirt("P001", "Blue Polo Shirt", "Blue", "L", 24));
        polos.put("P002", new Shirt("P002", "Black Polo Shirt", "Black", "M", 15));
        polos.put("P003", new Shirt("P003", "Maroon Polo Shirt", "Maroon", "XL", 20));
        polos.put("P004", new Shirt("P004", "Tan Polo Shirt", "Tan", "S", 19));

        List<Shirt> poloList = new ArrayList<>(polos.values());

        poloList.sort(new SortShirtByDesc());
        System.out.println("=== Inventory Report - Description ===");
        poloList.forEach(System.out::println);

        poloList.sort(new SortShirtByCount());
        System.out.println("=== Inventory Report - Count ===");
        poloList.forEach(System.out::println);
    }
}