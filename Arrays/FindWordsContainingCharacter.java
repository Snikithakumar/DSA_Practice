package Arrays;

/**
 * LeetCode 2942: Find Words Containing Character
 * https://leetcode.com/problems/find-words-containing-character/
 *
 * Time Complexity: O(Total characters in words)
 * Space Complexity: O(1) auxiliary
 */
public class FindWordsContainingCharacter {
    public java.util.List<Integer> findWordsContaining(String[] words, char x) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;
    }
}
