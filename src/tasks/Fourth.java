package tasks;

import java.util.*;

public class Fourth {
    public static void main(String[] args) {
        System.out.println(nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));
        System.out.println(generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));
        System.out.println(binarySystem(3));
        System.out.println(binarySystem(4));
        System.out.println(alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));
        System.out.println(countLetters("aaabbcdd"));
        System.out.println(countLetters("vvvvaajaaaaa"));
        System.out.println(convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));
        System.out.println(uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));
        System.out.println(shortestWay(new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}}));
        System.out.println(shortestWay(new int[][]{{2,7,3},
                {1, 4, 8},
                {4, 5, 8}}));
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
        System.out.println(switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));
    }

    public static String nonRepeatable(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (c == s.charAt(j))
                    s = s.substring(0, j) + s.substring(j + 1); //"выкалываем" повторяющиеся символы из строчки

            }
        }
        return s;
    }

    public static List<String> generateBrackets(int n){
        List<String> result = new ArrayList<>();
        builder(n,0,0,"", result);
        return result;
    }

    public static void builder(int n, int open, int close, String str, List<String> result){
        if(str.length()==2*n) {
            result.add(str);
            return;
        }
        if(open<n){
            builder(n, open+1, close, str + "(", result);
        }
        if(close<open){
            builder(n, open, close+1, str + ")", result);
        }
    }

    public static String binarySystem(int n) {
        String[] arr = new String[(int) Math.pow(2,n)];
        for (int i = 0; i < Math.pow(2,n); i++) {
            arr[i] = Integer.toString(i,2);
            if (arr[i].length() < n)
                arr[i] = "0".repeat(n - arr[i].length()) + Integer.toString(i,2);
        }
        List<String> list = Arrays.asList(arr);
        List<String> result = new ArrayList<>(list);
        for (int i = arr.length - 1; i >= 0; i--)
        {
            if (result.get(i).contains("00")) {
                result.remove(i);
            }

        }
        return result.toString();
    }

    public static String alphabeticRow(String s) {
        String[] results = new String[s.length()];
        Arrays.fill(results, "");
        int j = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (Math.abs((int) s.charAt(i) - (int) s.charAt(i+1)) == 1) {
                results[j] += s.substring(i, i + 2);
                for(int k = 1; k < results[j].length() - 1; k++)
                    if ((results[j].length() > 2) && (results[j].charAt(k) == results[j].charAt(k+1)))
                        results[j] = results[j].substring(0, k+1) + results[j].substring(k+2);
            }
            else j++;
        }
        return Collections.max(Arrays.asList(results), Comparator.comparing(String::length));
    }

    public static String countLetters(String s) {
        String str = "";
        char c = s.charAt(1);
        int count = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (c != s.charAt(i)) {
                str += "" + c + count;
                c = s.charAt(i);
                count = 0;
            }
            ++count;
        }
        if (count > 0)
            str += "" + c + count;
        StringBuilder reverseStr = new StringBuilder(str);
        reverseStr.reverse(); //переворачиваем
        String[] parts = reverseStr.toString().split("(?<=\\G.{"+2+"})"); //делим по 2 символа
        Arrays.sort(parts); //сортируем по возрастанию
        String result = "";
        for (int i = 0; i < parts.length; i++) {
            result += "" + parts[i].charAt(1) + parts[i].charAt(0);    //из массива делаем строку, меняя местами цифры и буквы
        }
        return result;
    }

    public static int convertToNum(String s) {
        String[] words = s.split(" ");
        int result = 0;
        for (String i : words) {
            switch (i) {
                case "one" -> result += 1;
                case "two" -> result += 2;
                case "three" -> result += 3;
                case "four" -> result += 4;
                case "five" -> result += 5;
                case "six" -> result += 6;
                case "seven" -> result += 7;
                case "eight" -> result += 8;
                case "nine" -> result += 9;
                case "ten" -> result += 10;
                case "eleven" -> result += 11;
                case "twelve" -> result += 12;
                case "thirteen" -> result += 13;
                case "fourteen" -> result += 14;
                case "fifteen" -> result += 15;
                case "sixteen" -> result += 16;
                case "seventeen" -> result += 17;
                case "eighteen" -> result += 18;
                case "nineteen" -> result += 19;
                case "twenty" -> result += 20;
                case "thirty" -> result += 30;
                case "foury" -> result += 40;
                case "fifty" -> result += 50;
                case "sixty" -> result += 60;
                case "seventy" -> result += 70;
                case "eighty" -> result += 80;
                case "ninety" -> result += 90;
                case "hundred" -> result *= 100;
            }
        }
        return result;
    }

    public static String uniqueSubstring(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String substring = "";
            for (int j = i; j < s.length(); j++) {
                if (substring.contains(String.valueOf(s.charAt(j))))
                    break;
                else substring += "" + s.charAt(j);
                if (substring.length() > result.length())
                    result = substring;
            }
        }
        return result;
    }

    public static int shortestWay(int[][] matrix) {

        //Вспомогательная матрица
        int[][] sup = new int[matrix.length][matrix.length];
        sup[0][0] = matrix[0][0];

        // Первый столбец вспомогательной матриы
        for (int i = 1; i < matrix.length; i++) {
            sup[i][0] = sup[i-1][0] + matrix[i][0];
        }

        // Первая строка вспомогательной матрицы
        for (int j = 1; j < matrix.length; j++) {
            sup[0][j] = sup[0][j-1] + matrix[0][j];
        }

        // Остальные ячейки
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix.length; j++) {
                sup[i][j] = Math.min(sup[i-1][j], sup[i][j-1]) + matrix[i][j];
            }
        }

        return sup[matrix.length-1][matrix.length-1];
    }

    public static String numericOrder (String s) {
        HashMap<Integer, String> order = new HashMap<>();
        String[] words = s.split(" ");
        for (String i : words) {
            for (int j = 0; j < i.length(); j++) {
                if (Character.isDigit(i.charAt(j))) {
                    order.put((int) i.charAt(j), i.replaceAll(String.valueOf(i.charAt(j)), ""));
                }
            }
        }
        String result = "";
        for (Integer i : order.keySet()) {
            String value = order.get(i);
            result += value + " ";
        }
        return result;
    }

    public static int switchNums(int n, int m) {
        // Преобразовываем числа в массивы символов
        char[] arrN = String.valueOf(n).toCharArray();
        char[] arrM = String.valueOf(m).toCharArray();

        // Сортируем массив с числами на замену по убыванию
        Arrays.sort(arrN);
        reverse(arrN);

        // Индекс элемента первого числа для замены
        int i = 0;

        // Замяем элементы второго числа элементами первого
        for (int j = 0; j < arrM.length && i < arrN.length; j++) {
            if (arrN[i] > arrM[j]) {
                arrM[j] = arrN[i];
                i++;
            }
        }
        String result = new String(arrM);
        return Integer.parseInt(result);
    }

    // Метод для разворота массива символов
    public static void reverse(char[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            i++;
            arr[j] = temp;
            j--;
        }
    }
}
