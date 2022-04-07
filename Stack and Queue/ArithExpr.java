
//Arithmetic Expression
//2*(3+4)
import java.util.*;

public class ArithExpr {
    public static String convertInfixToPostfix(String infix) {
        String postfix = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            // case operand
            if (ch >= 48 && ch <= 57) {
                postfix = postfix + ch;
            }

            if (ch >= 97 && ch <= 122) {
                postfix = postfix + ch;
            }
            // case '('
            if (ch == '(') {
                stack.push(ch);
            }
            // case ')'
            if (ch == ')') {
                while (stack.peek() != '(') {
                    postfix = postfix + stack.pop();
                }
                stack.pop();
            }
            // case operator
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                while (!stack.empty() &&
                        stack.peek() != '(' &&
                        precedence(ch) <= precedence(stack.peek())) // cho nay` kho nhat
                {
                    postfix = postfix + stack.pop();
                }
                stack.push(ch);
            }

        }

        // add operand cuoi' infix (hien dang o trong stack) vao postfix
        while (!stack.empty()) {
            postfix = postfix + stack.pop();
        }
        return postfix;
    }

    public static int precedence(Character ch) {
        if (ch == '+' || ch == '-')
            return 1;
        if (ch == '*' || ch == '/')
            return 10;
        return 100; // (ch=="^");
    }

    public static Double calPostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            Character ch = postfix.charAt(i);
            // operand -> push vao stack
            if (ch >= 48 && ch <= 57) {
                stack.push(Double.parseDouble(String.valueOf(ch)));
            }
            // operator
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // pop arguments from stack;
                Double arg2 = stack.pop();
                Double arg1 = stack.pop();
                Double result = calOperation(arg2, arg1, ch);
                // push the result onto stack
                stack.push(result);
            }
        }
        while (stack.isEmpty())
            return -1.0; // sai
        return stack.pop();
    }

    public static Double calOperation(Double arg2, Double arg1, int ch) {
        if (ch == '+') {
            return arg1 + arg2;
        }
        if (ch == '-') {
            return arg1 - arg2;
        }
        if (ch == '*') {
            return arg1 * arg2;
        }
        return arg1 / arg2;
    }

    public static void main(String[] args) {
        // bai7
        // String inf1 ="a-b*c^d+f";
        // String post1 = convertInfixToPostfix(inf1);
        // System.out.println(post1);
        String inf2 = "8-(4+2*3)/2+(7-3*4)";
        String post2 = convertInfixToPostfix(inf2);
        System.out.println(post2);
        System.out.println(calPostfix(post2));

        // bai8
        // String post3 ="12+31+*11+1+/";
        // System.out.println(calPostfix(post3));

        // String post4 = "8423*+2734*-/+-";
        // System.out.println(calPostfix(post4));
        // Double ans = 7.0-(6.0+4.0*2.0)/3.0;"1+2+3*4+5–6*7+8"
        // System.out.println(ans);
    }
}