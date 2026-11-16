class Solution {
    /**
     * LeetCode #88 - Merge Sorted Array
     *
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
     * and two integers m and n, representing the number of elements in nums1 and nums2.
     *
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order in-place inside nums1.
     *
     * Three-pointer backward merge algorithm:
     * Fills nums1 from the back to avoid overwriting unmerged elements.
     *
     * Time Complexity: O(M + N) linear pass.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }

        // Copy any remaining elements from nums2
        while (p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
    }
}
