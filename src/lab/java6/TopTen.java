package lab.java6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopTen {
    public static void topTen(String filePath) {
        File file = new File(filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Integer> wordCountMap = new HashMap<>();
        if (scanner != null) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                Pattern pattern = Pattern.compile("[a-zA-Zа-яёА-ЯЁ]*");
                Matcher matcher = pattern.matcher(word);
                if (matcher.matches()) {
                    if (wordCountMap.containsKey(word)) {
                        int count = wordCountMap.get(word);
                        wordCountMap.put(word, count + 1);
                    } else {
                        wordCountMap.put(word, 1);
                    }
                }
            }
        }
        if (scanner != null) {
            scanner.close();
        }
        List<Map.Entry<String, Integer>> wordCountList = new ArrayList<>(wordCountMap.entrySet());
        wordCountList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int count = 0;
        for (Map.Entry<String, Integer> entry: wordCountList) {
            if (count < 10) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
                count++;
            } else {
                break;
            }
        }
    }
}
