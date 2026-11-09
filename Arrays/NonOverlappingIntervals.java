import java.util.Arrays;

class Solution {
    /**
     * LeetCode #435 - Non-overlapping Intervals
     *
     * Given an array of intervals intervals where intervals[i] = [starti, endi],
     * return the minimum number of intervals you need to remove to make the rest
     * of the intervals non-overlapping.
     *
     * Time Complexity: O(N log N) where N is the number of intervals, due to sorting.
     * Space Complexity: O(1) or O(log N) depending on sort implementation.
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        // Greedy choice: sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removals = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If the start time of the current interval is strictly less than prevEnd, they overlap
            if (intervals[i][0] < prevEnd) {
                removals++;
            } else {
                // No overlap: update prevEnd to the end time of current interval
                prevEnd = intervals[i][1];
            }
        }

        return removals;
    }
}
