package Stack;

public class RemoveOutermostParentheses {

    /**
     * LeetCode #1021 - Remove Outermost Parentheses
     *
     * A valid parentheses string s is primitive if it is nonempty, and it cannot be split
     * into two or more nonempty valid parentheses strings.
     *
     * Return s after removing the outermost parentheses of every primitive string in
     * the primitive decomposition of s.
     *
     * Stack balance tracking:
     * Maintains an 'opened' counter. When encountering '(', append if opened > 0 (not outermost),
     * then increment. When encountering ')', decrement, and append if opened > 0 (not outermost).
     *
     * Time Complexity: O(N) where N is the length of s.
     * Space Complexity: O(N) to build the result string.
     */
    public String removeOuterParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int opened = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (opened > 0) {
                    sb.append(ch);
                }
                opened++;
            } else if (ch == ')') {
                opened--;
                if (opened > 0) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
