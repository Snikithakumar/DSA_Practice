package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 2696: Minimum String Length After Removing Substrings
 * https://leetcode.com/problems/minimum-string-length-after-removing-substrings/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class MinimumStringLengthAfterRemovingSubstrings {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && ((stack.peek() == 'A' && c == 'B') || (stack.peek() == 'C' && c == 'D'))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }
}
