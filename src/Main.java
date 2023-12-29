import java.util.*;

public class Main {

    public static void main(String[] args) {
       System.out.println(generateNonconsecutive("3 + 5 * (2 - 6)"));
       System.out.println(generateNonconsecutive("6 - 18 / (-1 + 4)"));
       System.out.println(generateNonconsecutive("5 / 5 * 5 / 5"));
       System.out.println(generateNonconsecutive("(9 - 3) * 8 / (5 + 1)"));
       System.out.println(generateNonconsecutive("5 & 3"));
    }

    public static int generateNonconsecutive(String expression) {
        expression = expression.replaceAll("\\s+", "");

        for (int i = 0; i < expression.length(); i++) {
            if (!Character.isDigit(expression.charAt(i)) && !isOperator(expression.charAt(i)) && expression.charAt(i)
                    != '(' && expression.charAt(i) != ')') {
                throw new NumberFormatException("Символ " + expression.charAt(i) + " не является числом или оператором!");
            }
        }

        return calculate(expression);
    }

    public static int calculate (String expression) {
        if (isNumeric(expression)) {
            return Integer.parseInt(expression);
        }
        //ищем скобки выполняем действие внутри них и заменяем их на ответ
        if (expression.indexOf('(') != -1) {
            String bracket = expression.substring(expression.indexOf('(') + 1, expression.indexOf(')'));

            expression = expression.substring(0, expression.indexOf('(')) + performOperation(bracket) +
                    expression.substring(expression.indexOf(')') + 1);
        }
        if (expression.contains("*") || expression.contains("/")) {
            expression = muldiv(expression);
        } else if (expression.contains("+") || expression.contains("-")) {
            expression = addsub(expression);
        }
        return calculate(expression);
    }

    public static String muldiv (String expression) {
        int mul = expression.indexOf('*');
        int div = expression.indexOf('/');
        int index;
        if (mul > 0 && div > 0) {
            index = Math.min(mul, div);
        } else {
            index = Math.max(mul, div);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = index - 1;
        while (i >= 0 && !isOperator(expression.charAt(i))) {
            stringBuilder.insert(0, expression.charAt(i));
            i--;
        }
        stringBuilder.append(expression.charAt(index));
        if (expression.charAt(index + 1) == '-') {
            stringBuilder.append("-");
            int j = index + 2;
            while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                stringBuilder.append(expression.charAt(j));
                j++;
            }
        } else {
            int j = index + 1;
            while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
                stringBuilder.append(expression.charAt(j));
                j++;
            }
        }
        return expression.substring(0, expression.indexOf(stringBuilder.toString())) + performOperation(String.valueOf(stringBuilder)) +
                expression.substring(expression.indexOf(stringBuilder.toString()) + stringBuilder.length());
    }

    public static String addsub (String expression) {
        int i = 0;
        int j;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < expression.length() && !isOperator(expression.charAt(i))) {
            stringBuilder.append(expression.charAt(i));
            i++;
        }
        stringBuilder.append(expression.charAt(i));
        if (expression.charAt(i + 1) == '-') {
            stringBuilder.append("-");
            j = i + 2;
        } else {
            j = i + 1;
        }
        while (j < expression.length() && Character.isDigit(expression.charAt(j))) {
            stringBuilder.append(expression.charAt(j));
            j++;
        }
        return performOperation(String.valueOf(stringBuilder)) + expression.substring(j);
    }

    public static int performOperation(String expression) {
        int operand1;
        int operand2;
        String operator = expression.replaceAll("\\d","");

        String[] parts = expression.split("[+\\-*/]");
        //если после оператора есть минус - значит второй операнд - отрицательное число
        if (operator.length() == 2 && operator.charAt(1) == '-') {
            operand1 = Integer.parseInt(parts[0]);
            operand2 = Integer.parseInt(parts[2]) * (-1);
            operator = "" + operator.charAt(0);
            //если оператора два и первый минус - значит первый операнд отрицательное число
        } else if (operator.length() == 2 && expression.charAt(0) == '-') {
            operand1 = Integer.parseInt(parts[1]) * (-1);
            operand2 = Integer.parseInt(parts[2]);
            operator = "" + operator.charAt(1);
        } else {
            operand1 = Integer.parseInt(parts[0]);
            operand2 = Integer.parseInt(parts[1]);
        }

        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Деление на ноль!");
                }
                yield operand1 / operand2;
            }
            default -> 0;
        };
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}


