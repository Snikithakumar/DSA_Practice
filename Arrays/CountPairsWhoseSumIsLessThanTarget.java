package Arrays;

/**
 * LeetCode 2824: Count Pairs Whose Sum is Less than Target
 * https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
 *
 * Time Complexity: O(N log N)
 * Space Complexity: O(1) auxiliary
 */
public class CountPairsWhoseSumIsLessThanTarget {
    public int countPairs(java.util.List<Integer> nums, int target) {
        java.util.Collections.sort(nums);
        int left = 0;
        int right = nums.size() - 1;
        int count = 0;

        while (left < right) {
            if (nums.get(left) + nums.get(right) < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
