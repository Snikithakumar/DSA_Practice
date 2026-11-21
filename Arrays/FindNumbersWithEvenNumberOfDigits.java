package Arrays;

/**
 * LeetCode 1295: Find Numbers with Even Number of Digits
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digits = (int) Math.log10(num) + 1;
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
