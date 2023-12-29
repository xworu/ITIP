package lab.java7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MatrixMaxElement {

    public static String findMaxElement(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        ExecutorService executorService = Executors.newFixedThreadPool(rows);

        for (int[] ints : matrix) {
            int[] matrixRow = new int[columns];

            System.arraycopy(ints, 0, matrixRow, 0, columns);

            executorService.submit(new maxElementTask(matrixRow));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "Наибольший элемент в матрице: " + maxElementTask.getMaxElement();
    }

    private static class maxElementTask implements Runnable {
        private static int maxElement;
        private final int[] array;

        public maxElementTask(int[] array) {
            this.array = array;
        }

        public static synchronized int getMaxElement() {
            return maxElement;
        }

        @Override
        public void run() {
            int maxE = array[0];
            for (int i = 1; i < array.length; i++) {
                maxE = Math.max(maxE, array[i]);
            }
            synchronized (maxElementTask.class) {
                maxElement = Math.max(maxElement, maxE);
            }
        }
    }
}
