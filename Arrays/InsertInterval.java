import java.util.ArrayList;
import java.util.List;

class Solution {
    /**
     * LeetCode #57 - Insert Interval
     *
     * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi]
     * sorted in ascending order by starti. You are also given an interval newInterval = [start, end]
     * representing another interval.
     *
     * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
     * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
     *
     * Time Complexity: O(N) where N is the number of intervals.
     * Space Complexity: O(N) for the output list.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals that come strictly before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge all intervals that overlap with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // 3. Add all remaining intervals that come strictly after newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
