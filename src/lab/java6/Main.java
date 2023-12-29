package lab.java6;

import static lab.java6.TopTen.topTen;

public class Main {
    public static void main(String[] args) {
        topTen("C:\\Users\\User\\IdeaProjects\\untitled\\src\\lab.java1.java6\\text.txt");

        Stack<Object> stack = new Stack<>(3);
        stack.push('a');
        stack.push('b');
        stack.push('c');
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());

        SalesSystem salesSystem = new SalesSystem();
        salesSystem.add("Яйца", 10, 70);
        salesSystem.add("Сахар", 5, 100);
        salesSystem.add("Миндаль", 20, 1100);
        salesSystem.printSalesList();
        System.out.println(salesSystem.totalSales());
        System.out.println(salesSystem.mostPopular());
    }
}
