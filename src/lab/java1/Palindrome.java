package lab.java1;

public class Palindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            boolean result = Palindrome(s);
            System.out.println(result);
        }
    }
    public static String reverseString(String s) {
        String str = "";
        for (int i = s.length(); i > 0; i--) {
            str += s.charAt(i-1);
        }
        return str;
    }
    public static boolean Palindrome(String s) {
        String s1 = reverseString(s);
        return s1.equals(s);
    }
}
