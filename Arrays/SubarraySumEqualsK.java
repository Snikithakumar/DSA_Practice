import java.util.HashMap;
import java.util.Map;

class Solution {
    /**
     * LeetCode #560 - Subarray Sum Equals K
     *
     * Given an array of integers nums and an integer k, return the total number
     * of subarrays whose sum equals to k.
     *
     * A subarray is a contiguous non-empty sequence of elements within an array.
     *
     * Time Complexity: O(N) where N is the length of nums.
     * Space Complexity: O(N) to store prefix sum frequencies in a HashMap.
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixSumCount = new HashMap<>();

        // Base case: a prefix sum of 0 has occurred once
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            currentSum += num;

            // If (currentSum - k) exists in the map, there are subarrays ending at the
            // current index whose sum equals k
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Update frequency of the current prefix sum
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
