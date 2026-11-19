package Stack;

public class MaximumNestingDepthOfTheParentheses {

    /**
     * LeetCode #1614 - Maximum Nesting Depth of the Parentheses
     *
     * Given a valid parentheses string s, return the nesting depth of s.
     * The nesting depth is the maximum number of open parentheses encountered concurrently.
     *
     * Counter / Stack tracking:
     * Increments depth on '(', updates global max, and decrements on ')'.
     *
     * Time Complexity: O(N) single pass through s.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public int maxDepth(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int currentDepth = 0;
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                currentDepth++;
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                }
            } else if (ch == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }
}
