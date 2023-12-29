package lab.java1;

public class Primes {
    public static void main(String[] args) {
        for (int j = 2; j <= 100; j++) {
            if (isPrime(j))
                System.out.println(j);
        }
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i ++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}