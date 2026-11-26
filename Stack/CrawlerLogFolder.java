package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 1598: Crawler Log Folder
 * https://leetcode.com/problems/crawler-log-folder/
 *
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        int depth = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (depth > 0) {
                    depth--;
                }
            } else if (!log.equals("./")) {
                depth++;
            }
        }
        return depth;
    }
}
