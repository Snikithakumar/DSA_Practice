package Arrays;

/**
 * LeetCode 1929: Concatenation of Array
 * https://leetcode.com/problems/concatenation-of-array/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }
}
