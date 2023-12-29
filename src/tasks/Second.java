package tasks;

import java.util.Arrays;
import java.util.Random;

public class Second {
    public static void main(String[] args) {
        duplicateChars("Donald");
        duplicateChars("orange");
        getInitials("Ryan Gosling");
        getInitials("Barack Obama");
        differenceEvenOdd(new int[]{44, 32, 86, 19});
        differenceEvenOdd(new int[]{22, 50, 16, 63, 31, 55});
        equalToAvg(new int[]{1, 2, 3, 4, 5});
        equalToAvg(new int[]{1, 2, 3, 4, 6});
        indexMult(new int[]{1, 2, 3});
        indexMult(new int[]{3, 3, -2, 408, 3, 31});
        reverse("Hello World");
        reverse("The quick brown fox.");
        Tribonacci(7);
        Tribonacci(11);
        pseudoHash(5);
        pseudoHash(10);
        pseudoHash(0);
        botHelper("Hello, I’m under the water, he helps me");
        botHelper("Two pepperoni pizzas please");
        isAnagram("listen", "silent");
        isAnagram("eleven plus two", "twelve plus one");
        isAnagram("hello", "world");


    }

    public static void duplicateChars(String word) {
        boolean Flag = false;
        for (int i = 0; i < word.length(); i++) {
            String a = "" + word.charAt(i);
            for (int j = 0; j < word.length(); j++) {
                if (i == j)
                    continue;
                if (a.equalsIgnoreCase(String.valueOf(word.charAt(j))))
                    Flag = true;
                break;
            }
        }
        System.out.println(Flag);
    }

    public static void getInitials(String name) {
        String[] parts = name.split(" ");
        System.out.println(parts[0].charAt(0) + "" + parts[1].charAt(0));
    }

    public static void differenceEvenOdd(int[] numbers) {
        int sumEven = 0;
        int sumOdd = 0;
        for(int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0)
                sumEven += numbers[i];
            else sumOdd += numbers[i];
        }
        System.out.println(Math.abs(sumEven - sumOdd));
    }

    public static void equalToAvg(int[] numbers) {
        boolean result = false;
        double average = 0;
        double sum = 0;
            for (int j = 0; j < numbers.length; j++) {
                sum += numbers[j];
            }
            average = sum / numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            if (average == numbers[i])
                result = true;

        }
        System.out.println(result);
    }

    public static void indexMult(int[] numbers) {
        int newNumbers[] = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            newNumbers[i] = numbers[i] * i;
        }
        System.out.println(Arrays.toString(newNumbers));
    }

    public static void reverse(String s) {
        String str = "";
        for (int i = s.length(); i > 0; i--) {
            str += s.charAt(i - 1);
        }
        System.out.println(str);
    }

    public static void Tribonacci(int n) {
        int s = 0;
        int t0 = 0;
        int t1 = 0;
        int t2 = 1;
        for (int i = 3; i < n; i++) {
            s = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 =s;
        }
        System.out.println(s);
    }

    public static void pseudoHash(int n) {
        String[] arr = {"a", "b", "c", "d", "e", "f", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String hash = "";
        for (int i = 0; i < n; i++) {
            int randomIndex = new Random().nextInt(arr.length);
            hash += arr[randomIndex];
        }
        System.out.println(hash);
    }

    public static void botHelper(String s) {
        s = s.toLowerCase();
        String subs = "\bhelp\b";
        if (s.contains(subs))
            System.out.println("Calling for a staff member");
        else
            System.out.println("Keep waiting" );
    }

    public static void isAnagram(String s1, String s2) {
        if (s1.length() != s2.length())
            System.out.println("false");
        s1 = s1.replaceAll("\\s", "");
        s2 = s2.replaceAll("\\s", "");
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        System.out.println(Arrays.equals(a1, a2));
    }

}
