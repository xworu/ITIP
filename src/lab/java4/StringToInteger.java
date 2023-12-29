package lab.java4;

public class StringToInteger {
    public static void stringToInteger(String s) {
        try {
            int n = Integer.parseInt(s);
            System.out.println("Число: " + n);
        } catch (NumberFormatException e) {
            CustomNumberFormatException c = new CustomNumberFormatException("Ошибка преобразования строки в число: " +
                    "строка не является числом");
            ExceptionLogger.logException(c);
            System.out.println(c.getMessage());
        }

    }
}
