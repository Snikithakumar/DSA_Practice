package Arrays;

/**
 * LeetCode 1732: Find the Highest Altitude
 * https://leetcode.com/problems/find-the-highest-altitude/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int maxAltitude = 0;
        for (int g : gain) {
            currentAltitude += g;
            if (currentAltitude > maxAltitude) {
                maxAltitude = currentAltitude;
            }
        }
        return maxAltitude;
    }
}
