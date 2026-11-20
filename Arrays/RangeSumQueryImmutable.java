class NumArray {
    private final int[] prefix;

    /**
     * LeetCode #303 - Range Sum Query - Immutable
     *
     * Precomputes prefix sums so that range sum queries [left, right]
     * can be answered in O(1) time.
     *
     * Time Complexity: O(N) precomputation, O(1) per sumRange query.
     * Space Complexity: O(N) for prefix sum storage.
     */
    public NumArray(int[] nums) {
        prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return prefix[right + 1] - prefix[left];
    }
}
