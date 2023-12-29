package lab.java7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WarehouseTransfer {
    private static final int loaderNumber = 3;
    private static final int maxWeight = 150;
    private final List<Integer> products;

    public WarehouseTransfer() {
        products = new ArrayList<>();
        products.add(151);
        products.add(10);
        products.add(100);
        products.add(25);
        products.add(50);
        products.add(75);
        products.add(33);
        products.add(17);
    }

    public void transfer() {
        ExecutorService executorService = Executors.newFixedThreadPool(loaderNumber);
        int currentWeight = 0;
        List<Integer> transferredProducts = new ArrayList<>();
        for (Integer product : products) {
            currentWeight += product;
            transferredProducts.add(product);
            if (currentWeight == maxWeight) {
                executorService.execute(new LoaderRealization(currentWeight));
                currentWeight = 0;
            } else if (currentWeight > maxWeight) {
                currentWeight -= product;
                transferredProducts.remove(product);
                executorService.execute(new LoaderRealization(currentWeight));
                currentWeight = product;
            }
        }
        if (transferredProducts.size() != products.size()) {
            for (int j = 0; j < transferredProducts.size() - products.size(); j++) {
                transferredProducts.add(products.get(products.size() - 1 - j));
                currentWeight += products.get(products.size()) - 1 - j;
            }
            executorService.execute(new LoaderRealization(currentWeight));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Все товары перенесены");
    }

    interface Loader extends Runnable {

    }

    static class LoaderRealization implements Loader {
        private final int currentWeight;
        public LoaderRealization (int currentWeight) {
            this.currentWeight = currentWeight;
        }

        @Override
        public void run() {
            System.out.println("Грузчик " + Thread.currentThread().getName() + " сейчас переносит " +
                    "и разгружает товары весом " + currentWeight + " кг");
            try {
                Thread.sleep(100 * currentWeight);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Грузчик " + Thread.currentThread().getName() + " завершил разгрузку товаров и " +
                    "возвращается на склад");
        }
    }
}
