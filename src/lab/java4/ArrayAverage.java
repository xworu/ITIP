package lab.java4;

public class ArrayAverage {
    public static void arrayAverage() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int sum = 0;
        int count = 0;

        for (int j : arr) {
            try {
                sum += j;
                count++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Выход за пределы массива");
            } catch (NumberFormatException e) {
                System.out.println("Элемент не является числом");
            }
        }

        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("Среднее арифметическое элементов массива: " + average);
        }
    }
}






