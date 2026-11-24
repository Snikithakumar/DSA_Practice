package Arrays;

/**
 * LeetCode 2114: Maximum Number of Words Found in Sentences
 * https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/
 *
 * Time Complexity: O(Total characters across sentences)
 * Space Complexity: O(1)
 */
public class MaximumNumberOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for (String sentence : sentences) {
            int spaces = 0;
            for (int i = 0; i < sentence.length(); i++) {
                if (sentence.charAt(i) == ' ') {
                    spaces++;
                }
            }
            maxWords = Math.max(maxWords, spaces + 1);
        }
        return maxWords;
    }
}
