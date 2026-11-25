package Arrays;

/**
 * LeetCode 1672: Richest Customer Wealth
 * https://leetcode.com/problems/richest-customer-wealth/
 *
 * Time Complexity: O(M * N)
 * Space Complexity: O(1)
 */
public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] customer : accounts) {
            int wealth = 0;
            for (int bank : customer) {
                wealth += bank;
            }
            if (wealth > maxWealth) {
                maxWealth = wealth;
            }
        }
        return maxWealth;
    }
}
