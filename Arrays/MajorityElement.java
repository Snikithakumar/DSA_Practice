class Solution {
    /**
     * LeetCode #169 - Majority Element
     *
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than floor(n / 2) times.
     *
     * Boyer-Moore Voting Algorithm:
     * Maintains a candidate and a counter. Counter increases on matching candidate
     * and decreases on different elements. Since majority element occurs > n / 2 times,
     * it is guaranteed to remain as candidate at the end.
     *
     * Time Complexity: O(N) single pass.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
