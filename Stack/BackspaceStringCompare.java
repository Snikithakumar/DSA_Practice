package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare {

    /**
     * LeetCode #844 - Backspace String Compare
     *
     * Given two strings s and t, return true if they are equal when both are typed
     * into empty text editors. '#' means a backspace character.
     *
     * Time Complexity: O(M + N) where M and N are lengths of s and t.
     * Space Complexity: O(M + N) to maintain the character stacks.
     */
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    private String build(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            if (ch != '#') {
                stack.push(ch);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }
}
