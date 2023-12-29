package tasks;

import java.text.SimpleDateFormat;
import java.util.*;

public class Fifth {
    public static void main(String[] args) {
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println(spiderVsFly("G4", "C4") );
        System.out.println(spiderVsFly("A4", "B2") );
        System.out.println(spiderVsFly("A4", "C2") );
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println(totalPoints(new String[] {"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println(sumsUp(new int[] {1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[] {1, 2, 3, 7, 9}));
        System.out.println(sumsUp(new int[] {10, 9, 7, 2, 8}));
        System.out.println(sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7}));
        System.out.println(takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[] {"10%"}));
        System.out.println(takeDownAverage(new String[] {"53%", "79%"}));
        System.out.println(caesarCipher("encode", "zzz", 3));
        System.out.println(caesarCipher("decode", "epqswx pewx xewo!", 4));
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println(timeDifference("Los Angeles","April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));

    }

    public static boolean sameLetterPattern (String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (!map.containsKey(c1)) {
                map.put(c1, c2);
            }

            if (map.get(c1) != c2) {
                return false;
            }
        }

        return true;
    }

    public static String spiderVsFly(String spider, String fly) {
        String path = spider;
        if (spider.charAt(0) == fly.charAt(0)) {
            //если паук с мухой на одной букве
            if (spider.charAt(1) > fly.charAt(1)) {
                //паук выше мухи -> паук спускается
                for (int i = Integer.parseInt("" + spider.charAt(1)) - 1; i > Integer.parseInt("" + fly.charAt(1)) - 1; i--) {
                    path += "-" + spider.charAt(0) + i;
                }
            } else {
                //паук ниже мухи -> паук поднимается
                for (int i = Integer.parseInt("" + spider.charAt(1)) + 1; i < Integer.parseInt("" + fly.charAt(1)) + 1; i++) {
                    path += "-" + spider.charAt(0) + i;
                }
            }
        }

        if (Math.abs(spider.charAt(0) - fly.charAt(0)) == 1 || Math.abs(spider.charAt(0) - fly.charAt(0)) == 7) {
            //если паук с мухой на соседних буквах и паук выше
            if (spider.charAt(1) > fly.charAt(1)) {
                //паук спускается
                for (int i = Integer.parseInt("" + spider.charAt(1)) - 1; i > Integer.parseInt("" + fly.charAt(1)) - 1; i--) {
                    path += "-" + spider.charAt(0) + i;
                }
                path += "-" + fly;
            } else {
                //если паук ниже, прыгает на букву мухи и поднимается
                for (int i = Integer.parseInt("" + spider.charAt(1)); i < Integer.parseInt("" + fly.charAt(1)) + 1; i++) {
                    path += "-" + fly.charAt(0) + i;
                }
            }
        }

        if (Math.abs(spider.charAt(0) - fly.charAt(0)) == 2 || Math.abs(spider.charAt(0) - fly.charAt(0)) == 6) {
            //паук с мухой через букву и паук выше
            if (spider.charAt(1) > fly.charAt(1)) {
                //паук доходит до цифры мухи на своей букве, потом по этой цифре опускается до буквы мухи
                for (int i = Integer.parseInt("" + spider.charAt(1)) - 1; i > Integer.parseInt("" + fly.charAt(1)) - 1; i--) {
                    path += "-" + spider.charAt(0) + i;
                }
                if (spider.charAt(0) > fly.charAt(0)) {
                    if (Math.abs(spider.charAt(0) - fly.charAt(0)) == 2) {
                        path += "-" + (char) (spider.charAt(0) - 1) + fly.charAt(1);
                    } else {
                        path += "-" + (char) (spider.charAt(0) + 1) + fly.charAt(1);
                    }
                } else {
                    if (Math.abs(spider.charAt(0) - fly.charAt(0)) == 2) {
                        path += "-" + (char) (spider.charAt(0) + 1) + fly.charAt(1);
                    } else {
                        path += "-" + (char) (fly.charAt(0) + 1) + fly.charAt(1);
                    }
                }
                path += "-" + fly;
            } else {
                //паук ниже, паук по своей цифре доходит до буквы мухи, потом по этой букве поднимается до цифры мухи
                if (spider.charAt(0) > fly.charAt(0)) {
                    if (Math.abs(spider.charAt(0) - fly.charAt(0)) == 2) {
                        path += "-" + (char) (spider.charAt(0) - 1) + spider.charAt(1);
                    } else {
                        path += "-" + (char) (spider.charAt(0) + 1) + spider.charAt(1);
                    }
                } else {
                    if (Math.abs(spider.charAt(0) - fly.charAt(0)) == 2) {
                        path += "-" + (char) (spider.charAt(0) + 1) + spider.charAt(1);
                    } else {
                        path += "-" + (char) (fly.charAt(0) + 1) + spider.charAt(1);
                    }
                }
                for (int i = Integer.parseInt("" + spider.charAt(1)); i < Integer.parseInt("" + fly.charAt(1)) + 1; i++) {
                    path += "-" + fly.charAt(0) + i;
                }
            }
        }

        if (Math.abs(spider.charAt(0) - fly.charAt(0)) > 2 && Math.abs(spider.charAt(0) - fly.charAt(0)) < 6) {
            //паук с мухой через две или три буквы, паук по своей букве спускается до точки А0, потом поднимается до мухи
            for (int i = Integer.parseInt("" + spider.charAt(1)) - 1; i > 0; i--) {
                path += "-" + spider.charAt(0) + i;
            }
            path += "-A0";
            for (int i = 1; i < Integer.parseInt("" + fly.charAt(1)) + 1; i++) {
                path += "-" + fly.charAt(0) + i;
            }
        }
        return path;
    }

    public static int digitsCount(long n) {
        if (n < 10)
            return 1;
        else {
            return 1 + digitsCount(n / 10);
        }
    }

    public static int totalPoints(String[] guessedWords, String scrambleWord) {
        int totalPoints = 0;
        char[] scrambledChars = scrambleWord.toCharArray();
        int[] letterCount = new int[26];
        for (char c : scrambledChars) {
            letterCount[c - 'a']++;
        }

        for (String word : guessedWords) {
            if (isValidWord(word.toCharArray(), letterCount)) {
                switch (word.length()) {
                    case 3 -> totalPoints += 1;
                    case 4 -> totalPoints += 2;
                    case 5 -> totalPoints += 3;
                    case 6 -> totalPoints += 54;
                }
            }
        }

        return totalPoints;
    }

    private static boolean isValidWord(char[] word, int[] letterCount) {
        int[] letterCountWord = new int[26];
        for (char c : word) {
            letterCountWord[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (letterCountWord[i] > letterCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static String sumsUp(int[] numbers) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == 8) {
                    int[] arr = {numbers[i], numbers[j]};
                    Arrays.sort(arr);
                    result.add(arr);
                }
            }
        }
        return Arrays.deepToString(result.toArray());
    }

    public static String takeDownAverage(String[] arr) {
        int sum = 0;
        for (String s : arr) {
            String num = s.substring(0, s.length() - 1);
            sum += Integer.parseInt(num);
        }
        double averageFirst = (double) sum / arr.length;
        double averageSecond = averageFirst - 5;
        long result = Math.round(averageSecond * (arr.length + 1) - sum);
        return result + "%";
    }

    public static String caesarCipher(String command, String message, int shift) {
        String result = "";
        //a - 97
        //z - 122
        if (command.equals("encode")) {
            for (int i = 0; i < message.length(); i++) {
                if ((int) message.charAt(i) > 96 && (int) message.charAt(i) < 123) {
                    if ((int) message.charAt(i) + shift > 122) {
                        result += (char) ((((int) message.charAt(i)) + shift) - 122 + 96);
                    } else {
                        result += (char) ((int) message.charAt(i) + shift);
                    }
                } else
                    result += message.charAt(i);
            }
        }
        else if (command.equals("decode")) {
            for (int i = 0; i < message.length(); i++) {
                if ((int) message.charAt(i) > 96 && (int) message.charAt(i) < 123) {
                    if ((int) message.charAt(i) - shift < 97) {
                        result += (char) (121 - (96 - (((int) message.charAt(i)) - shift)));
                    } else {
                        result += (char) ((int) message.charAt(i) - shift);

                    }
                } else
                    result += message.charAt(i);
            }
        }
        return result.toUpperCase();
    }

    public static int setSetup(int n, int k) {
        return factorial(n) / factorial(n - k);
    }

    private static int factorial (int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static String timeDifference(String cityA, String timestamp, String cityB) {
        //получаем месяц, день и год
        String[] parts = timestamp.split(" ");
        String monthS = parts[0];
        int month = switch (monthS) {
            case "January" -> 1;
            case "February" -> 2;
            case "March" -> 3;
            case "April" -> 4;
            case "May" -> 5;
            case "June" -> 6;
            case "July" -> 7;
            case "August" -> 8;
            case "September" -> 9;
            case "October" -> 10;
            case "November" -> 11;
            case "December" -> 12;
            default -> 0;
        };
        int day = Integer.parseInt(parts[1].replace(",", ""));
        int year = Integer.parseInt(parts[2]);
        //получаем часы и минуты
        String time = parts[3];
        String[] timeParts = time.split(":");
        int hours = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        Date date = new Date(year - 1900, month - 1, day, hours, minutes);
        String timeZoneA = getTimeZone(cityA);
        String timeZoneB = getTimeZone(cityB);
        int offsetA = extractTimeOffset(timeZoneA);
        int offsetB = extractTimeOffset(timeZoneB);
        date.setTime(date.getTime() + (offsetB - offsetA));
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-M-d HH:mm");
        return outputFormat.format(date);
    }

    public static String getTimeZone(String city) {
        switch (city) {
            case "Los Angeles" -> {
                return "GMT-8:00";
            }
            case "New York" -> {
                return "GMT-5:00";
            }
            case "Caracas" -> {
                return "GMT-4:30";
            }
            case "Buenos Aires" -> {
                return "GMT-3:00";
            }
            case "London" -> {
                return "GMT";
            }
            case "Rome" -> {
                return "GMT+1:00";
            }
            case "Moscow" -> {
                return "GMT+3:00";
            }
            case "Tehran" -> {
                return "GMT+3:30";
            }
            case "New Delhi" -> {
                return "GMT+5:30";
            }
            case "Beijing" -> {
                return "GMT+8:00";
            }
            case "Canberra" -> {
                return "GMT+10:00";
            }
            default -> {
                return "GMT";
            }
        }
    }

    public static int extractTimeOffset(String timeZone) {
        int hours = 0;
        int minutes = 0;
        int indexPlus = timeZone.indexOf('+');
        int indexMinus = timeZone.indexOf('-');

        if (timeZone.contains("+")) {
            String[] parts = timeZone.substring(indexPlus + 1).split(":");
            hours = Integer.parseInt(parts[0]);
            minutes = Integer.parseInt(parts[1]);
        } else if (timeZone.contains("-")) {
            String[] parts = timeZone.substring(indexMinus + 1).split(":");
            hours = Integer.parseInt(parts[0]);
            minutes = Integer.parseInt(parts[1]);
            hours = -hours;
            minutes = -minutes;
        }
        return (hours * 60 + minutes) * 60000;
    }

    public static boolean isNew(int number) {
        String strNum = String.valueOf(number);
        char[] arr = strNum.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j] && arr[j] != '0') {
                    return false;
                }
            }
        }
        return true;
    }

}
