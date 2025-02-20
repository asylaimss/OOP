package models;
public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;
    private int inventory;

    public Shirt(String id, String description, String color, String size, int inventory) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
        this.inventory = inventory;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return inventory;
    }

    public void addItems(int count) {
        inventory += count;
    }

    public void removeItems(int count) {
        if (inventory >= count) {
            inventory -= count;
        } else {
            System.out.println("Error: Not enough inventory for " + id);
        }
    }

    @Override
    public String toString() {
        return "Shirt ID: " + id + "\nDescription: " + description + "\nColor: " + color + "\nSize: " + size + "\nInventory: " + inventory;
    }
}