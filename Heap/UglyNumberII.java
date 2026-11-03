import java.util.*;

class Solution {
    public int nthUglyNumber(int n) {

        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();

        minHeap.offer(1L);
        seen.add(1L);

        int[] primes = {2, 3, 5};
        long curr = 1L;

        for (int i = 0; i < n; i++) {
            curr = minHeap.poll();

            for (int prime : primes) {
                long next = curr * prime;
                if (seen.add(next)) {
                    minHeap.offer(next);
                }
            }
        }

        return (int) curr;
    }
}
