import java.util.*;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;

            while (!stack.isEmpty() && nums[currentIndex] > nums[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = nums[currentIndex];
            }

            if (i < n) {
                stack.push(i);
            }
        }

        return result;
    }
}
