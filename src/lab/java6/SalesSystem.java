package lab.java6;

import java.util.*;

public class SalesSystem {
    private final LinkedList<String> salesList;
    private final HashMap<String, Integer> salesCount;
    private final HashMap<String, Double> salesAmount;

    public SalesSystem() {
        salesList = new LinkedList<>();
        salesCount = new HashMap<>();
        salesAmount = new HashMap<>();
    }

    public void add(String product, int amount, double price) {
        salesList.add(product);
        salesCount.put(product,salesCount.getOrDefault(product, 0) + amount);
        salesAmount.put(product, salesAmount.getOrDefault(product, 0.0) + amount * price);
    }

    public void printSalesList() {
        System.out.println("Список проданных товаров:");
        for (String product : salesList) {
            System.out.println(product);
        }
    }

    public String totalSales() {
        double total = 0;
        for (double amount : salesAmount.values()) {
            total += amount;
        }
        return "Общая сумма продаж: " + total;
    }

    public String mostPopular() {
        String mostPopular = null;
        int max = 0;
        for(Map.Entry<String,Integer> entry : salesCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                mostPopular = entry.getKey();
            }
        }
        return "Самый популярный товар: " + mostPopular;
    }
}
