package Graphs;

/**
 * LeetCode #547 - Number of Provinces
 *
 * <p>There are n cities. Some of them are connected, while some are not. If city a is connected directly
 * with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.
 *
 * <p>A province is a group of directly or indirectly connected cities and no other cities outside of the group.
 *
 * <p>You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are
 * directly connected, and isConnected[i][j] = 0 otherwise.
 *
 * <p>Return the total number of provinces.
 *
 * <p>Time Complexity: O(N^2), where N is the number of cities. We traverse the N x N adjacency matrix.
 * <p>Space Complexity: O(N), for the visited boolean array and the recursive call stack in the worst case.
 */
public class NumberOfProvinces {

    /**
     * Finds the total number of connected components (provinces) in the graph.
     *
     * @param isConnected An n x n adjacency matrix representing direct connections between cities.
     * @return The total number of provinces.
     */
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0 || isConnected[0] == null || isConnected[0].length == 0) {
            return 0;
        }

        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                provinces++;
                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    /**
     * Depth-First Search helper to traverse and mark all cities in the current province.
     *
     * @param current The current city being visited.
     * @param isConnected The adjacency matrix representing city connections.
     * @param visited Array tracking whether a city has already been visited.
     */
    private void dfs(int current, int[][] isConnected, boolean[] visited) {
        visited[current] = true;
        int n = isConnected.length;

        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (isConnected[current][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, isConnected, visited);
            }
        }
    }
}
