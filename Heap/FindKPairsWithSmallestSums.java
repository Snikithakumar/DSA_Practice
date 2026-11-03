import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) ->
            Long.compare(
                (long) nums1[a[0]] + nums2[a[1]],
                (long) nums1[b[0]] + nums2[b[1]]
            )
        );

        int limit = Math.min(k, nums1.length);
        for (int i = 0; i < limit; i++) {
            minHeap.offer(new int[]{i, 0});
        }

        while (!minHeap.isEmpty() && result.size() < k) {
            int[] curr = minHeap.poll();
            int i = curr[0];
            int j = curr[1];

            result.add(List.of(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }
}
