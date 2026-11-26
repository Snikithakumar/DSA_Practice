package Arrays;

/**
 * LeetCode 2798: Number of Employees Who Met the Target
 * https://leetcode.com/problems/number-of-employees-who-met-the-target/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class NumberOfEmployeesWhoMetTheTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int h : hours) {
            if (h >= target) {
                count++;
            }
        }
        return count;
    }
}
