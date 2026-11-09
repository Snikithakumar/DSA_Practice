package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class SimplifyPath {

    /**
     * LeetCode #71 - Simplify Path
     *
     * Given an absolute path for a Unix-style file system, which begins with a slash '/',
     * transform this path into its simplified canonical path.
     *
     * Time Complexity: O(N) where N is the length of the path string.
     * Space Complexity: O(N) to store directory tokens in the stack.
     */
    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return "/";
        }

        String[] tokens = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (token.isEmpty() || token.equals(".")) {
                continue;
            }

            if (token.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(token);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder canonicalPath = new StringBuilder();
        // Traverse stack in FIFO (bottom-to-top) order
        Iterator<String> it = stack.descendingIterator();
        while (it.hasNext()) {
            canonicalPath.append("/").append(it.next());
        }

        return canonicalPath.toString();
    }
}
