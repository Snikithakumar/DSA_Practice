package Stack;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {

    /**
     * LeetCode #1441 - Build an Array With Stack Operations
     *
     * Given an integer array target and an integer n, returns the list of stack
     * operations ("Push" and "Pop") needed to build target from the stream [1, n].
     *
     * Greedy stream simulation:
     * For each number in the stream from 1 upwards:
     * - Push the number.
     * - If it matches current target element, advance target index.
     * - Otherwise, immediately pop it.
     *
     * Time Complexity: O(target[last]) <= O(N).
     * Space Complexity: O(1) auxiliary space (excluding returned list).
     */
    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();
        int targetIndex = 0;

        for (int num = 1; num <= n && targetIndex < target.length; num++) {
            operations.add("Push");

            if (num == target[targetIndex]) {
                targetIndex++;
            } else {
                operations.add("Pop");
            }
        }

        return operations;
    }
}
