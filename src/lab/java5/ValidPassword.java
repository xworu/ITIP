package lab.java5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassword {

    public static void validPassword(String password) {
        if (isValid(password)) {
            System.out.println("Пароль " + password + " корректен");
        } else {
            System.out.println("Пароль " + password + " не корректен");
        }
    }
    private static boolean isValid(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }
        Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,16})");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
