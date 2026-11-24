package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 2390: Removing Stars From a String
 * https://leetcode.com/problems/removing-stars-from-a-string/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class RemovingStarsFromAString {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
