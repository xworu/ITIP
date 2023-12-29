package tasks;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class Third {
    public static void main(String[] args) {
        System.out.println(replaceVovels("apple"));
        System.out.println(replaceVovels("Even if you did this task not by yourself, you have to understand " +
                "every single line of code."));
        System.out.println(stringTransform("hello"));
        System.out.println(stringTransform("bookkeeper"));
        System.out.println(doesBlockFit(new int[]{1, 3, 5, 4, 5}));
        System.out.println(doesBlockFit(new int[]{1, 8, 1, 1, 1}));
        System.out.println(doesBlockFit(new int[]{1, 2, 2, 1, 1}));
        System.out.println(numCheck(243));
        System.out.println(numCheck(52));
        System.out.println(countRoots(new int[]{1, -3, 2}));
        System.out.println(countRoots(new int[]{2, 5, 2}));
        System.out.println(countRoots(new int[]{1, -6, 9}));
        System.out.println((salesData(new String[][]{ {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"} })));
        System.out.println(salesData(new String[][]{ {"Fridge", "Shop2", "Shop3"},
                {"Microwave", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Laptop", "Shop3", "Shop4"},
                {"Phone", "Shop1", "Shop2", "Shop3", "Shop4"} }));
        System.out.println(validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println(waveForm(new int[]{3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[]{1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}));
        System.out.println(commonVowel("Hello world"));
        System.out.println(commonVowel("Actions speak louder than words."));
        System.out.println(dataScience(new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {5, 5, 5, 5, 5},
                {7, 4, 3, 14, 2},
                {1, 0, 11, 10, 1}}));
        System.out.println(dataScience(new int[][] {
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}}));
        System.out.println();
    }

    public static String replaceVovels(String word) {

        return word.toLowerCase().replaceAll("[aeiouy]", "*");
    }

    public static String stringTransform(String str) {
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == str.charAt(i-1))
                str = str.substring(0, i - 1) + "Double" + str.toUpperCase().charAt(i) + str.substring(i + 1);
        }
        return str;
    }

    public static boolean doesBlockFit(int[] inp) {
        int[] measurements = Arrays.copyOfRange(inp, 0, 3);
        int[] limits = Arrays.copyOfRange(inp, 3, 5);
        Arrays.sort(measurements);
        Arrays.sort(limits);
        for(int i = 0; i < 2; i++) {
            if (measurements[i] <= limits[0] && measurements[i + 1] <= limits[1])
                return true;
        }
        return false;
    }
    public static boolean numCheck(int number) {
        String num = "" + number;
        int sumSquare = 0;
        for(int i = 0; i < num.length(); i++) {
            sumSquare += (int) num.charAt(i) * (int) num.charAt(i);
        }
        return sumSquare % 2 == number % 2;
    }
    public static int countRoots(int[] numbers) {
        int D = numbers[1] * numbers[1] - 4 * numbers[0] * numbers[2];
        int counter = 0;
        double x1, x2;
        if (D > 0) {
            x1 = (-numbers[1] - Math.sqrt(D)) / (2 * numbers[0]);
            if (x1 % 1 == 0)
                counter += 1;
            x2 = (-numbers[1] + Math.sqrt(D)) / (2 * numbers[0]);
            if (x2 % 1 == 0)
                counter += 1;
        }
        if (D == 0) {
            double x;
            x = -numbers[1] / (2 * numbers[0]);
            if (x % 1 == 0)
                counter += 1;
        }
        return counter;
    }

    public static String salesData(String[][] sales) {
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < sales.length; i++) {
            if (sales[i].length >= 5)
                array.add(sales[i][0]);
        }
        String[] items = array.toArray(new String[0]);
        return Arrays.toString(items);
    }

    public static boolean validSplit(String s) {
        boolean result = true;
        String[] words = s.split(" ");
        char a = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++) {
            if (a == words[i].charAt(0)) {
                a = words[i].charAt(words[i].length() - 1);
            }else
                result = false;
        }
        return result;
    }

    public static boolean waveForm(int[] numbers) {
        boolean result = false;
        for (int i = 1; i < numbers.length - 1; i++) {
            if ((numbers[i - 1] > numbers[i] && numbers[i] < numbers[i + 1]) || (numbers[i - 1] > numbers[i] &&
                    numbers[i] > numbers[i + 1])) {
                result = true;
            }
        }
        return result;
    }

    public static String commonVowel(String s) {
        s = s.toLowerCase();
        String[][] vowelCount = {{"a", "e", "i", "o", "u", "y"}, {"0", "0", "0", "0", "0", "0"}};

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a')
                vowelCount[1][0] = Integer.toString(Integer.parseInt(vowelCount[1][0]) + 1);
            if (c == 'e')
                vowelCount[1][1] = Integer.toString(Integer.parseInt(vowelCount[1][1]) + 1);
            if (c == 'i')
                vowelCount[1][2] = Integer.toString(Integer.parseInt(vowelCount[1][2]) + 1);
            if (c == 'o')
                vowelCount[1][3] = Integer.toString(Integer.parseInt(vowelCount[1][3]) + 1);
            if (c == 'u')
                vowelCount[1][4] = Integer.toString(Integer.parseInt(vowelCount[1][4]) + 1);
            if (c == 'y')
                vowelCount[1][5] = Integer.toString(Integer.parseInt(vowelCount[1][5]) + 1);
        }
        int commonCount = Integer.parseInt(Collections.max(Arrays.asList(vowelCount[1])));
        String result = null;
        for (int i = 0; i < vowelCount[1].length; i++) {
            if (vowelCount[1][i].equals(Integer.toString(commonCount))) {
                result = vowelCount[0][i];
                break;
            }

        }
        return result;
    }

    public static String dataScience(int[][] arr) {
        int[] sum = new int[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i != j)
                    sum[j] += arr[i][j];
            }
        }
        for (int k = 0; k < arr.length; k++)
            arr[k][k] = Math.round((float) sum[k] / (arr.length - 1));
        return Arrays.deepToString(arr);
    }
}
