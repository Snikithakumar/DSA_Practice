package Arrays;

/**
 * LeetCode 1512: Number of Good Pairs
 * https://leetcode.com/problems/number-of-good-pairs/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int pairs = 0;
        for (int num : nums) {
            pairs += count[num];
            count[num]++;
        }
        return pairs;
    }
}
