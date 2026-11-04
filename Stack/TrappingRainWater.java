import java.util.*;

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int totalWater = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[bottom];
                int width = i - stack.peek() - 1;
                totalWater += boundedHeight * width;
            }
            stack.push(i);
        }

        return totalWater;
    }
}
