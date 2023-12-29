package tasks;

public class First {
    public static void main(String [] args) {
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println(containers(3,4,2));
        System.out.println(containers(5,0,2));
        System.out.println(containers(4,1,4));
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5,4,5));
        System.out.println(triangleType(3,4,5));
        System.out.println(triangleType(5,1,1));
        System.out.println(ternaryEvaluation(8,4));
        System.out.println(ternaryEvaluation(1,11));
        System.out.println(ternaryEvaluation(5,9));
        System.out.println(howManyItems(22,1.4,2));
        System.out.println(howManyItems(45,1.8,1.9));
        System.out.println(howManyItems(100,2,2));
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println(gcd(48,18));
        System.out.println(gcd(52,8));
        System.out.println(gcd(259,28));
        System.out.println(ticketSeller(70, 1500));
        System.out.println(ticketSeller(24, 950));
        System.out.println(ticketSeller(53, 1250));
        System.out.println(tables(5,2));
        System.out.println(tables(31,20));
        System.out.println(tables(123,58));
    }

    public static double convert(float gallons) {
        return (gallons * 3.785);
    }

    public static int fitCalc(int min, int intension) {
        return min * intension;
    }

    public static int containers(int a, int b, int c) {
        return a*20 + b*50 + c*100;
    }

    public static String triangleType(int x, int y, int z) {
        if (x + y < z || x + z < y || y + z < x || x <= 0 || y <= 0 || z <= 0) {
            return "not a triangle";
        } else if (x == y && y == z) {
            return "isosceles";
        } else if (x == y || y == z || x == z) {
            return "equilateral";
        } else {
            return "different-sided";
        }
    }

    public static int ternaryEvaluation(int a, int b) {
        return a > b ? a : b;
    }

    public static int howManyItems(int l, double w, double h) {
        return (int) (l / (w*h*2));
    }

    public static int factorial (int n) {
        int result=1;
        for (int i = 1; i <= n; i++)
        {
            result *= i;
        }
        return  result;
    }

    public static int gcd(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a%b;
            } else {
                b = b%a;
            }
        }
        return (a + b);
    }

    public static int ticketSeller(int amount, int price) {
        return (int) (amount*price*0.72);
    }

    public static int tables(int students, int tables) {
        float req = students - tables*2;
        if (req > 0) {
            req = (int) (Math.ceil(req/2));
        } else {
            req = 0;
        }
        return (int) req;
    }
}
