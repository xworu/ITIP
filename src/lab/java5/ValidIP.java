package lab.java5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidIP {

    public static void validIP(String ip) {
        if (isValid(ip)) {
            System.out.println("IP-адрес " + ip + " корректен");
        } else {
            System.out.println("IP-адрес " + ip + " не корректен");
        }
    }

    public static boolean isValid (String ip) {
        Pattern pattern = Pattern.compile("^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9]?[0-9])\\.){3}" +
                "(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]?)$");
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }
}
