import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * LeetCode #448 - Find All Numbers Disappeared in an Array
     *
     * Given an array nums of n integers where nums[i] is in the range [1, n],
     * return an array of all the integers in the range [1, n] that do not appear in nums.
     *
     * In-place Sign Negation Technique:
     * Treats the array indices as hash buckets. For each value x in nums, marks
     * the element at index |x| - 1 as negative. Unvisited positive elements in the
     * second pass correspond to missing numbers.
     *
     * Time Complexity: O(N) two linear passes.
     * Space Complexity: O(1) in-place auxiliary space (excluding returned list).
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // First pass: mark index (abs(num) - 1) as negative
        for (int i = 0; i < nums.length; i++) {
            int targetIndex = Math.abs(nums[i]) - 1;
            if (nums[targetIndex] > 0) {
                nums[targetIndex] = -nums[targetIndex];
            }
        }

        // Second pass: positive values identify missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
