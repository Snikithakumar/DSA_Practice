package Stack;

public class MinimumAddToMakeParenthesesValid {

    /**
     * LeetCode #921 - Minimum Add to Make Parentheses Valid
     *
     * Given a parentheses string s, return the minimum number of parentheses we
     * must add to make the resulting string valid.
     *
     * Balance Counter tracking:
     * - 'closeNeeded': counts open parentheses waiting for matching close parentheses.
     * - 'openNeeded': counts close parentheses that appeared without a matching open parenthesis.
     *
     * Time Complexity: O(N) single pass.
     * Space Complexity: O(1) auxiliary space.
     */
    public int minAddToMakeValid(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int openNeeded = 0;
        int closeNeeded = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                closeNeeded++;
            } else if (ch == ')') {
                if (closeNeeded > 0) {
                    closeNeeded--;
                } else {
                    openNeeded++;
                }
            }
        }

        return openNeeded + closeNeeded;
    }
}
