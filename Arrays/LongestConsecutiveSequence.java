import java.util.HashSet;
import java.util.Set;

class Solution {
    /**
     * LeetCode #128 - Longest Consecutive Sequence
     *
     * Given an unsorted array of integers nums, return the length of the longest
     * consecutive elements sequence.
     *
     * An algorithm that runs in O(n) time is required.
     *
     * Time Complexity: O(N) where N is the length of nums.
     * Space Complexity: O(N) for storing elements in the HashSet.
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Only attempt to build a sequence if num is the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
