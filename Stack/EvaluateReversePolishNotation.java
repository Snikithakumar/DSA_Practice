package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {

    /**
     * LeetCode #150 - Evaluate Reverse Polish Notation
     *
     * Evaluates the value of an arithmetic expression in Reverse Polish Notation.
     * Valid operators are '+', '-', '*', and '/'. Each operand may be an integer or
     * another expression. Division truncates toward zero.
     *
     * Time Complexity: O(N) where N is the number of tokens.
     * Space Complexity: O(N) for the evaluation stack.
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a + b);
                    break;
                }
                case "-": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                }
                case "*": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a * b);
                    break;
                }
                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }
}
