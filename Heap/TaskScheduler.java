import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int count : freq) {
            if (count > 0) {
                maxHeap.offer(count);
            }
        }

        int intervals = 0;

        while (!maxHeap.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;

            while (cycle > 0 && !maxHeap.isEmpty()) {
                int count = maxHeap.poll();

                if (count > 1) {
                    temp.add(count - 1);
                }

                intervals++;
                cycle--;
            }

            for (int count : temp) {
                maxHeap.offer(count);
            }

            if (!maxHeap.isEmpty()) {
                intervals += cycle;
            }
        }

        return intervals;
    }
}
