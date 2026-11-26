package Arrays;

/**
 * LeetCode 1389: Create Target Array in the Given Order
 * https://leetcode.com/problems/create-target-array-in-the-given-order/
 *
 * Time Complexity: O(N^2)
 * Space Complexity: O(N)
 */
public class CreateTargetArrayInTheGivenOrder {
    public int[] createTargetArray(int[] nums, int[] index) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] target = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            target[i] = list.get(i);
        }
        return target;
    }
}
