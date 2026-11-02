import java.util.*;

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap =
            new PriorityQueue<>((a, b) ->
                Long.compare(
                    distanceSquared(b),
                    distanceSquared(a)
                )
            );

        for (int[] point : points) {
            maxHeap.offer(point);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }

    private long distanceSquared(int[] point) {
        return (long) point[0] * point[0]
             + (long) point[1] * point[1];
    }
}
