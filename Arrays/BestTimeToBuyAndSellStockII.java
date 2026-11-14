class Solution {
    /**
     * LeetCode #122 - Best Time to Buy and Sell Stock II
     *
     * You are given an integer array prices where prices[i] is the price of a given
     * stock on the ith day. Find and return the maximum profit you can achieve.
     * You may complete as many transactions as you like.
     *
     * Greedy approach:
     * Since every profitable upward transaction can be accumulated, capture every
     * positive daily difference prices[i] - prices[i - 1].
     *
     * Time Complexity: O(N) single pass.
     * Space Complexity: O(1) in-place auxiliary space.
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit;
    }
}
