package Arrays;

/**
 * LeetCode 1365: How Many Numbers Are Smaller Than the Current Number
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 *
 * Time Complexity: O(N + K) where K is range of numbers (0 to 100)
 * Space Complexity: O(K)
 */
public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }
        return result;
    }
}
