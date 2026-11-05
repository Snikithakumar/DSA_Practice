package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #417 - Pacific Atlantic Water Flow
 *
 * <p>Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right
 * and bottom edges.
 *
 * <p>Water can only flow in four directions (up, down, left, right) from a cell to another one with height equal
 * or lower.
 *
 * <p>Find the list of grid coordinates where water can flow to both the Pacific and Atlantic oceans.
 *
 * <p>Time Complexity: O(M * N) where M is the number of rows and N is the number of columns.
 * Each cell is visited at most twice (once for Pacific DFS, once for Atlantic DFS).
 * <p>Space Complexity: O(M * N) for the visited arrays and recursion call stack in the worst case.
 */
public class PacificAtlanticWaterFlow {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * Determines all coordinates from which water can flow to both Pacific and Atlantic oceans.
     *
     * @param heights 2D grid representing heights of cells.
     * @return List of coordinates [r, c] that can reach both oceans.
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Perform reverse DFS from top (Pacific) and bottom (Atlantic) edges
        for (int c = 0; c < n; c++) {
            if (!pacific[0][c]) {
                dfs(0, c, pacific, heights);
            }
            if (!atlantic[m - 1][c]) {
                dfs(m - 1, c, atlantic, heights);
            }
        }

        // Perform reverse DFS from left (Pacific) and right (Atlantic) edges
        for (int r = 0; r < m; r++) {
            if (!pacific[r][0]) {
                dfs(r, 0, pacific, heights);
            }
            if (!atlantic[r][n - 1]) {
                dfs(r, n - 1, atlantic, heights);
            }
        }

        // Intersect cells reachable from both oceans
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }

        return result;
    }

    /**
     * Helper method to perform reverse DFS traversal.
     * Traverses to neighboring cells with height >= current cell's height.
     *
     * @param r Current row index.
     * @param c Current column index.
     * @param visited Visited array for the respective ocean.
     * @param heights Grid heights.
     */
    private void dfs(int r, int c, boolean[][] visited, int[][] heights) {
        visited[r][c] = true;
        int m = heights.length;
        int n = heights[0].length;

        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, visited, heights);
            }
        }
    }
}
