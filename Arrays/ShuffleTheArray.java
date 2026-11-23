package Arrays;

/**
 * LeetCode 1470: Shuffle the Array
 * https://leetcode.com/problems/shuffle-the-array/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[2 * i + 1] = nums[i + n];
        }
        return result;
    }
}
