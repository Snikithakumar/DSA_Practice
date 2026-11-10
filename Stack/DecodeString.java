package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString {

    /**
     * LeetCode #394 - Decode String
     *
     * Given an encoded string, return its decoded string.
     * The encoding rule is: k[encoded_string], where the encoded_string inside the square
     * brackets is being repeated exactly k times.
     *
     * Time Complexity: O(maxK * N) where N is length of s and maxK is maximum multiplier.
     * Space Complexity: O(N) for count and string stacks.
     */
    public String decodeString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                currentString = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder decoded = stringStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decoded.append(currentString);
                }
                currentString = decoded;
            } else {
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
