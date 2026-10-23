
class Solution {
    public boolean containsDuplicate(int[] nums) {
        java.util.HashSet<Integer> set = new java.util.HashSet<>();

        for (int n : nums) {
            if (!set.add(n))
                return true;
        }

        return false;
    }
}
