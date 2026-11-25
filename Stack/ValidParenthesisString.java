package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 678: Valid Parenthesis String
 * https://leetcode.com/problems/valid-parenthesis-string/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        int low = 0;  // minimum possible open parentheses
        int high = 0; // maximum possible open parentheses

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low--;
                high--;
            } else { // '*' can be '(', ')', or empty
                low--;
                high++;
            }
            if (high < 0) {
                return false;
            }
            if (low < 0) {
                low = 0;
            }
        }
        return low == 0;
    }
}
