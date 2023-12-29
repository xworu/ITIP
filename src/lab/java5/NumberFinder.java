package lab.java5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFinder {
    public static void numberFinder(String text) {
        Pattern pattern = Pattern.compile("[+-]?\\d+\\.?,?\\d*");
        Matcher matcher = pattern.matcher(text);
        System.out.println("Введенная строка содержит следующие числа:");

        while (matcher.find()) {
            String number = matcher.group();
            try {
                if (number.contains(".") || number.contains(",")) {
                    number = number.replace(',', '.');
                    double value = Double.parseDouble(number);
                    System.out.println(value);
                } else {
                    int value = Integer.parseInt(number);
                    System.out.println(value);
                }

            } catch (NumberFormatException e) {
                System.err.println("Ошибка: неверный формат числа - " + number);
            }
        }
    }
}
