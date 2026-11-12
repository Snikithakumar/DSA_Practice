import java.util.*;

class Solution {
    /**
     * LeetCode #49 - Group Anagrams
     *
     * Given an array of strings strs, group the anagrams together.
     * You can return the answer in any order.
     *
     * Time Complexity: O(N * K log K) where N is the number of strings and K is the maximum length of a string.
     * Space Complexity: O(N * K) to store the grouped anagrams in a HashMap.
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedKey = new String(chars);

            anagramGroups.computeIfAbsent(sortedKey, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramGroups.values());
    }
}
