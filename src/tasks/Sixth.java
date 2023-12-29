package tasks;

import java.util.*;

public class Sixth {
    public static void main(String[] args) {
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D  e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println(collect("intercontinentalisationalism", 6));
        System.out.println(collect("strengths", 3));
        System.out.println(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15));
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println(twoProduct(new int[]{1, 2, 3, 9, 4, 5, 15}, 45));
        System.out.println(twoProduct(new int[]{1, 2, 3, 9, 4, 15, 3, 5}, 45) );
        System.out.println(twoProduct(new int[]{1,  2, -1,  4,  5,  6,  10, 7}, 20));
        System.out.println(twoProduct(new int[]{1, 2, 3, 4, 5,  6, 7, 8, 9, 10}, 10));
        System.out.println(twoProduct(new int[]{100, 12, 4, 1, 2}, 15));
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println(pilish_string("33314444"));
        System.out.println("TOP");
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccc"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println(findLCS("abcd", "bd"));
        System.out.println(findLCS("aggtab", "gxtxamb"));
        System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
        System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));
    }

    public static String hiddenAnagram(String sentence, String anagram) {
        sentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
        anagram = anagram.replaceAll("[^a-zA-Z]", "").toLowerCase();

        ArrayList<Character> anagramList = new ArrayList<>();
        for (int i = 0; i < anagram.length(); i++) {
            anagramList.add(anagram.charAt(i));
        }


        return searchAnagram(sentence, anagramList);
    }

    public static String searchAnagram(String sentence, final List<Character> anagramList) {
        String result = "";
        List<Character> subAnagramList = new ArrayList<>(anagramList);
        for (int i = 0; i < sentence.length(); i++) {
            if (subAnagramList.contains(sentence.charAt(i))) {
                result += sentence.charAt(i);
                subAnagramList.remove(subAnagramList.indexOf(sentence.charAt(i)));
                if (subAnagramList.isEmpty()) {
                    return result;
                }
            } else {
                return searchAnagram(sentence.substring(1), anagramList);
            }
        }
        return "notfound";
    }

    public static String collect(String s, int n) {
        String[] result = new String[s.length() / n];
        Arrays.sort(sliceCollector(s, n, result));
        return Arrays.toString(result);
    }

    public static String[] sliceCollector(String s, int n, String[] result) {
        if (s.length() < n) {
            return new String[0];
        }
        for (int i = 0; i < s.length() / n; i++) {
            result[i] = s.substring(0, n);
            sliceCollector(s.substring(n), n, result);
        }
        return result;
    }

    public static String nicoCipher(String message, String key) {
        // Создаем массив символов ключа и сортируем его по алфавиту
        char[] keyChar = key.toCharArray();
        Arrays.sort(keyChar);
        // Создаем карту пар символ-число
        HashMap<Character, Integer> keyMap= new HashMap<>();
        for (int i = 0; i < keyChar.length; i++) {
            keyMap.put(keyChar[i], i + 1);
        }
        // Назначаем числа отсортированным буквам ключа
        int[] keyNumber = new int[key.length()];
        for (int i = 0; i < key.length(); i++) {
            keyNumber[i] = keyMap.get(key.charAt(i));
        }

        // Создаем двумерный массив для хранения букв сообщения
        int rows = (int) Math.ceil((double) message.length() / key.length());
        char[][] messageArray = new char[rows][key.length()];

        // Заполняем двумерный массив с буквами сообщения
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (index < message.length()) {
                    messageArray[i][j] = message.charAt(index);
                    index++;
                } else {
                    // Если буквы сообщения закончились, заполняем оставшиеся ячейки пробелом
                    messageArray[i][j] = ' ';
                }
            }
        }


        // Сортируем столбцы двумерного массива в соответствии с числовыми значениями ключа
        for (int i = 0; i < key.length(); i++) {
            for (int j = i + 1; j < key.length(); j++) {
                if (keyNumber[i] > keyNumber[j]) {
                    // Меняем местами столбцы и числовые значения ключа
                    swapColumns(messageArray, i, j);
                    swapIntegers(keyNumber, i, j);
                }
            }
        }

        // Формируем сообщение
        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < key.length(); j++) {
                encodedMessage.append(messageArray[i][j]);
            }
        }

        return encodedMessage.toString();
    }

    private static void swapColumns(char[][] array, int index1, int index2) {
        for (int i = 0; i < array.length; i++) {
            char temp = array[i][index1];
            array[i][index1] = array[i][index2];
            array[i][index2] = temp;
        }
    }

    private static void swapIntegers(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static String twoProduct(int[] arr, int n) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] * arr[j] == n) {
                    map.put(j - i, new int[]{arr[i], arr[j]});
                }
            }
        }
        if (map.isEmpty()) {
            return Arrays.toString(new int[0]);
        }
        return Arrays.toString(map.get(Collections.min(map.keySet())));
    }

    public static int[] isExact(int n) {
        if (findBorder(n, 2) == 0)
            return new int[0];
        return new int[]{n, findBorder(n, 2)};
    }

    public static int findBorder(int n, int i) {
        double m = (double) n / i;
        if (m % 1 != 0) {
            return 0;
        }
        if (m == 1) {
            return i;
        }

        return findBorder((int) m, i + 1);
    }

    public static String fractions(String n) {
        String[] nSplit = n.split("\\.");
        int whole = Integer.parseInt(nSplit[0]);
        String[] fraction = nSplit[1].split("\\(");
        int k = (fraction[1].substring(0, fraction[1].length() - 1)).length(); // количество цифр в периоде десятичной дроби
        if (!fraction[0].isEmpty()) {
            int m = fraction[0].length(); // количество цифр после запятой до периода
            int a = Integer.parseInt(fraction[0] + fraction[1].substring(0, fraction[1].length() - 1)); //все цифры после запятой
            int b = Integer.parseInt(fraction[0].replaceFirst("^0*", "")); //все цифры после запятой до периода и без ведущих нулей
            int denominator = Integer.parseInt("9".repeat(k) + "0".repeat(m));
            int numerator = whole * denominator + (a - b);
            return numerator / gcd(numerator, denominator) + "/" + denominator / gcd(numerator, denominator);
        } else {
            int a = Integer.parseInt(fraction[0] + fraction[1].substring(0, fraction[1].length() - 1));;
            int denominator = Integer.parseInt("9".repeat(k));
            int numerator = whole * denominator + a;
            return numerator / gcd(numerator, denominator) + "/" + denominator / gcd(numerator, denominator);
        }
    }

    public static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a%b;
            } else {
                b = b%a;
            }
        }
        return (a + b);
    }

    public static String pilish_string(String s) {
        String pi = "314159265358979";
        String result = "";
        for (int i = 0; i < pi.length(); i++) {
            if (s.isEmpty()) {
                return result;
            }
            if (s.length() < Integer.parseInt("" + pi.charAt(i))) {
                result += s;
                for (int j = 0; j < Integer.parseInt("" + pi.charAt(i)) - s.length(); j++) {
                    result += result.charAt(result.length() - 1);

                }
                return result;
            } else {
                result += s.substring(0, Integer.parseInt("" + pi.charAt(i))) + " ";
                s = s.substring(Integer.parseInt("" + pi.charAt(i)));
            }
        }
        return result;
    }

    public static String isValid(String input) {
        HashMap<Character, Integer> charAmount = new HashMap<>(); // HashMap для подсчета повторений каждого символа
        for (int i = 0; i < input.length(); i++) {
            if (!charAmount.containsKey(input.charAt(i))) {
                charAmount.put(input.charAt(i), 1);
            } else {
                charAmount.put(input.charAt(i), charAmount.get(input.charAt(i)) + 1);
            }
        }
        HashMap<Integer, Integer> amount = new HashMap<>(); // HashMap для подсчета количества количества повторений (повторение-количество)
        for (Integer value : charAmount.values()) {
            if (!amount.containsKey(value)) {
                amount.put(value, 1);
            } else {
                amount.put(value, amount.get(value) + 1);
            }
        }
        if (amount.size() > 2) {
            return "NO";
        } else if (amount.size() == 1) {
            return "YES";
        }
        int a = Collections.max(amount.entrySet(), Map.Entry.comparingByKey()).getKey(); // количество повтоений символа, который мы потенциально можем убрать
        int b = Collections.min(amount.entrySet(), Map.Entry.comparingByKey()).getKey(); // количество повторений остальных символов
        if (Collections.min(amount.entrySet(), Map.Entry.comparingByValue()).getValue() != 1) { //проверяем, один ли символ отличается повторением
            return "NO";
        }
        if (a - b == 1) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static String findLCS(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // Заполняем таблицу длин LCS
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // Собираем последовательность
        StringBuilder lcs = new StringBuilder();
        int i = s1.length(), j = s2.length();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.insert(0, s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            }
            else
                j--;
        }

        return lcs.toString();
    }

    public static int generateNonconsecutive(String expression) {
        expression = expression.replaceAll("\\s+", "");

        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i)) && !isOperator(expression.charAt(i)) && expression.charAt(i)
                    != '(' && expression.charAt(i) != ')') {
                throw new NumberFormatException("Символ " + expression.charAt(i) + " не является числом или оператором!");
            }
        }

        return calculate(expression);
    }

    public static int calculate (String expression) {
        if (isNumeric(expression)) {
            return Integer.parseInt(expression);
        }
        //ищем скобки выполняем действие внутри них и заменяем их на ответ
        if (expression.indexOf('(') != -1) {
            String bracket = expression.substring(expression.indexOf('(') + 1, expression.indexOf(')'));

            expression = expression.substring(0, expression.indexOf('(')) + performOperation(bracket) +
                    expression.substring(expression.indexOf(')') + 1);
        }
        if (expression.contains("*") || expression.contains("/")) {
            expression = muldiv(expression);
        } else if (expression.contains("+") || expression.contains("-")) {
            expression = addsub(expression);
        }
        return calculate(expression);
    }

    public static String muldiv (String expression) {
        int mul = expression.indexOf('*');
        int div = expression.indexOf('/');
        int index;
        if (mul > 0 && div > 0) {
            index = Math.min(mul, div);
        } else {
            index = Math.max(mul, div);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = index - 1;
        while (i >= 0 && !isOperator(expression.charAt(i))) {
            stringBuilder.insert(0, expression.charAt(i));
            i--;
        }
        stringBuilder.append(expression.charAt(index));
        if (expression.charAt(index + 1) == '-') {
            stringBuilder.append("-");
            int j = index + 2;
            while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                stringBuilder.append(expression.charAt(j));
                j++;
            }
        } else {
            int j = index + 1;
            while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                stringBuilder.append(expression.charAt(j));
                j++;
            }
        }
        return expression.substring(0, expression.indexOf(stringBuilder.toString())) + performOperation(String.valueOf(stringBuilder)) +
                expression.substring(expression.indexOf(stringBuilder.toString()) + stringBuilder.length());
    }

    public static String addsub (String expression) {
        int i = 0;
        int j;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < expression.length() && !isOperator(expression.charAt(i))) {
            stringBuilder.append(expression.charAt(i));
            i++;
        }
        stringBuilder.append(expression.charAt(i));
        if (expression.charAt(i + 1) == '-') {
            stringBuilder.append("-");
            j = i + 2;
        } else {
            j = i + 1;
        }
        while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
            stringBuilder.append(expression.charAt(j));
            j++;
        }
        return performOperation(String.valueOf(stringBuilder)) + expression.substring(j);
    }

    public static int performOperation(String expression) {
        int operand1;
        int operand2;
        String operator = expression.replaceAll("\\d","");

        String[] parts = expression.split("[+\\-*/]");
        //если после оператора есть минус - значит второй операнд - отрицательное число
        if (operator.length() == 2 && operator.charAt(1) == '-') {
            operand1 = Integer.parseInt(parts[0]);
            operand2 = Integer.parseInt(parts[2]) * (-1);
            operator = "" + operator.charAt(0);
            //если оператора два и первый минус - значит первый операнд отрицательное число
        } else if (operator.length() == 2 && expression.charAt(0) == '-') {
            operand1 = Integer.parseInt(parts[1]) * (-1);
            operand2 = Integer.parseInt(parts[2]);
            operator = "" + operator.charAt(1);
        } else {
            operand1 = Integer.parseInt(parts[0]);
            operand2 = Integer.parseInt(parts[1]);
        }

        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Деление на ноль!");
                }
                yield operand1 / operand2;
            }
            default -> 0;
        };
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}
