package Stack;

public class RemoveAllAdjacentDuplicatesInString {

    /**
     * LeetCode #1047 - Remove All Adjacent Duplicates In String
     *
     * Given a string s consisting of lowercase English letters, repeatedly remove
     * adjacent, matching duplicates until no more can be removed.
     *
     * Stack-like simulation using StringBuilder:
     * Appends characters to the buffer, popping the last character if it matches
     * the incoming character.
     *
     * Time Complexity: O(N) single pass through the string.
     * Space Complexity: O(N) to store the result string.
     */
    public String removeDuplicates(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == ch) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
