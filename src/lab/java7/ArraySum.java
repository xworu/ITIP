package lab.java7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArraySum {

    public static String calculateSum(int[] array, int numThreads) {
        int arrayLength = array.length;
        int chunkSize = arrayLength / numThreads;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        int startIndex = 0;
        int endIndex = chunkSize;

        for (int i = 0; i < numThreads; i++) {

            int[] subArray = new int[endIndex - startIndex];

            System.arraycopy(array, startIndex, subArray, 0, endIndex - startIndex);

            executorService.submit(new ArraySumTask(subArray));

            startIndex = endIndex;
            endIndex = startIndex + chunkSize;
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Сумма элементов массива: " + ArraySumTask.getTotalSum();
    }

    private static class ArraySumTask implements Runnable {
        private static int totalSum = 0;
        private final int[] array;

        public ArraySumTask(int[] array) {
            this.array = array;
        }

        public static synchronized int getTotalSum() {
            return totalSum;
        }

        @Override
        public void run() {
            int sum = 0;
            for (int element : array) {
                sum += element;
            }
            synchronized (ArraySumTask.class) {
                totalSum += sum;
            }
        }
    }
}
