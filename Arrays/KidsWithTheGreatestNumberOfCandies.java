package Arrays;

/**
 * LeetCode 1431: Kids With the Greatest Number of Candies
 * https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
public class KidsWithTheGreatestNumberOfCandies {
    public java.util.List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int c : candies) {
            if (c > maxCandies) {
                maxCandies = c;
            }
        }

        java.util.List<Boolean> result = new java.util.ArrayList<>(candies.length);
        for (int c : candies) {
            result.add(c + extraCandies >= maxCandies);
        }
        return result;
    }
}
