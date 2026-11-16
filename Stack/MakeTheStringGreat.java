package Stack;

public class MakeTheStringGreat {

    /**
     * LeetCode #1544 - Make The String Great
     *
     * Given a string s of lower and upper case English letters, repeatedly remove
     * adjacent pairs where s[i] and s[i+1] are the same letter with opposite case
     * (|s[i] - s[i+1]| == 32).
     *
     * Stack simulation using StringBuilder:
     * Inspects the top character of the stack buffer and cancels if opposite case.
     *
     * Time Complexity: O(N) single pass through s.
     * Space Complexity: O(N) to store resulting string.
     */
    public String makeGood(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && Math.abs(sb.charAt(len - 1) - ch) == 32) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
