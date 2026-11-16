class Solution {
    /**
     * LeetCode #66 - Plus One
     *
     * You are given a large integer represented as an integer array digits.
     * Increment the large integer by one and return the resulting array of digits.
     *
     * Traversal with carry propagation:
     * Iterates from the least significant digit. If a digit < 9, increments and returns.
     * Otherwise, sets to 0 and carries over. If all digits were 9, creates a new array of length n + 1 with leading 1.
     *
     * Time Complexity: O(N) where N is the number of digits.
     * Space Complexity: O(1) in-place unless all digits are 9, which requires O(N) for a new array.
     */
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }

        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // All digits were 9 (e.g., 999 -> 1000)
        int[] result = new int[n + 1];
        result[0] = 1;

        return result;
    }
}
