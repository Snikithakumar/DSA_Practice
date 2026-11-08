import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    /**
     * LeetCode #56 - Merge Intervals
     *
     * Given an array of intervals where intervals[i] = [starti, endi], merge all
     * overlapping intervals, and return an array of the non-overlapping intervals
     * that cover all the intervals in the input.
     *
     * Time Complexity: O(N log N) where N is the number of intervals, due to sorting.
     * Space Complexity: O(N) or O(log N) depending on the sorting implementation.
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals based on starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If the merged list is empty or current interval does not overlap with previous
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlap: merge by expanding the end time of previous interval
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
