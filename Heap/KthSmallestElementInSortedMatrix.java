import java.util.*;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int rows = Math.min(n, k);
        for (int r = 0; r < rows; r++) {
            minHeap.offer(new int[]{matrix[r][0], r, 0});
        }

        int count = 0;
        int result = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            result = curr[0];
            count++;

            if (count == k) {
                break;
            }

            int r = curr[1];
            int c = curr[2];

            if (c + 1 < n) {
                minHeap.offer(new int[]{matrix[r][c + 1], r, c + 1});
            }
        }

        return result;
    }
}
