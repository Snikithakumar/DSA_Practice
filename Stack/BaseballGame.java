package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BaseballGame {

    /**
     * LeetCode #682 - Baseball Game
     *
     * Computes the total score recorded after evaluating a sequence of operations:
     * - An integer x: Add score x.
     * - '+': Add sum of previous two scores.
     * - 'D': Add double the previous score.
     * - 'C': Invalidate (remove) the previous score.
     *
     * Time Complexity: O(N) where N is the number of operations.
     * Space Complexity: O(N) for the score stack.
     */
    public int calPoints(String[] operations) {
        if (operations == null || operations.length == 0) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (String op : operations) {
            switch (op) {
                case "+": {
                    int top = stack.pop();
                    int newScore = top + stack.peek();
                    stack.push(top);
                    stack.push(newScore);
                    break;
                }
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }

        int totalScore = 0;
        for (int score : stack) {
            totalScore += score;
        }

        return totalScore;
    }
}
