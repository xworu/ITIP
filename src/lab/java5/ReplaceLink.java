package lab.java5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceLink {

    public static String replaseLink(String link) {
        if (isValid(link)) {
             return "https://" + link.substring(4);
        }
        return "Выражение " + link + " не является ссылкой";
    }

    public static boolean isValid(String link) {
        Pattern pattern = Pattern.compile("(www\\.[\\w.-]+(/[\\w-./?%&=]*)?)");
        Matcher matcher = pattern.matcher(link);
        return matcher.matches();
    }
}
