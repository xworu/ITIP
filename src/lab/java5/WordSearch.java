package lab.java5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearch {
    public static void wordSearch(String text, String letter) {
        Pattern pattern = Pattern.compile("\\b" + letter + "\\w*'?\\w*\\b");
        Matcher matcher = pattern.matcher(text);
        System.out.println("Слова, начинающиеся с буквы " + letter + ":");
        while (matcher.find()) {
            String word = matcher.group();
            System.out.println(word);
        }
    }
}
