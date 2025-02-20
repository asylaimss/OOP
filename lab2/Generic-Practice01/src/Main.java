import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, String> productNames = new TreeMap<>();
        productNames.put("Blue Polo Shirt", "1S01");
        productNames.put("Black Polo Shirt", "1S02");
        productNames.put("Red Ball Cap", "1H01");
        productNames.put("Duke Mug", "1M02");

        String[] parts = {"1S01", "1S01", "1S01", "1S01", "1S01", "1S01", "1S01",
                "1S02", "1S02", "1S02", "1S02", "1S02", "1S02",
                "1H01", "1H01", "1H01", "1H01", "1H01",
                "1M02", "1M02", "1M02"};

        ProductCounter pc1 = new ProductCounter(productNames);
        pc1.processList(parts);
        pc1.printReport();
    }
}