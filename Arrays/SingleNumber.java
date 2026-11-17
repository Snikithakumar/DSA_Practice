class Solution {
    /**
     * LeetCode #136 - Single Number
     *
     * Given a non-empty array of integers nums, every element appears twice except
     * for one. Find that single one.
     *
     * Bitwise XOR properties:
     * - a ^ a = 0
     * - a ^ 0 = a
     * - XOR is commutative and associative.
     * XOR-ing all elements cancels out every pair and leaves the unique number.
     *
     * Time Complexity: O(N) single pass.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
