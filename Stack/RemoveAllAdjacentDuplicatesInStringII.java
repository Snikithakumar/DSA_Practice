package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 1047: Remove All Adjacent Duplicates In String
 * Note: Check if exists; if so, create LeetCode 1209: Remove All Adjacent Duplicates in String II
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class RemoveAllAdjacentDuplicatesInStringII {
    private static class Pair {
        char ch;
        int count;
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Deque<Pair> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == c) {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                stack.push(new Pair(c, 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair p = stack.removeLast();
            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }
}
