package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 1475: Final Prices With a Special Discount in a Shop
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone();
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int prevIndex = stack.pop();
                result[prevIndex] -= prices[i];
            }
            stack.push(i);
        }
        return result;
    }
}
