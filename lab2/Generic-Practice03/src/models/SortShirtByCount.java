package models;

import java.util.Comparator;

public class SortShirtByCount implements Comparator<models.Shirt> {
    public int compare(models.Shirt s1, models.Shirt s2) {
        return Integer.compare(s1.getCount(), s2.getCount());
    }
}