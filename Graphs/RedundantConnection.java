package Graphs;

/**
 * LeetCode #684 - Redundant Connection
 *
 * <p>In this problem, a tree is an undirected graph that is connected and has no cycles.
 * You are given a graph that started as a tree with n nodes labeled from 1 to n, with one
 * additional edge added. The added edge has two different vertices chosen from 1 to n, and was
 * not an edge that already existed.
 *
 * <p>The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [ui, vi]
 * that represents an undirected edge between nodes ui and vi.
 *
 * <p>Return an edge that can be removed so that the resulting graph is a tree of n nodes.
 * If there are multiple answers, return the answer that occurs last in the input.
 *
 * <p>Time Complexity: O(N * alpha(N)), where N is the number of vertices and alpha is the
 * inverse Ackermann function (effectively O(1) in practice).
 * <p>Space Complexity: O(N), for the parent and rank arrays.
 */
public class RedundantConnection {

    /**
     * Finds the redundant edge in the graph using Disjoint Set Union (DSU) with
     * path compression and union by rank.
     *
     * @param edges 2D array of edges where each edge is [u, v].
     * @return The edge that forms a cycle and can be removed.
     */
    public int[] findRedundantConnection(int[][] edges) {
        if (edges == null || edges.length == 0) {
            return new int[0];
        }

        // Determine the maximum node label to safely dimension parent and rank arrays
        int maxNode = edges.length;
        for (int[] edge : edges) {
            if (edge[0] > maxNode) {
                maxNode = edge[0];
            }
            if (edge[1] > maxNode) {
                maxNode = edge[1];
            }
        }

        int[] parent = new int[maxNode + 1];
        int[] rank = new int[maxNode + 1];

        // Initialize each node as its own parent
        for (int i = 1; i <= maxNode; i++) {
            parent[i] = i;
        }

        // Process edges in input order
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If u and v already belong to the same component, this edge creates a cycle
            if (!union(u, v, parent, rank)) {
                return edge;
            }
        }

        return new int[0];
    }

    /**
     * Finds the representative root of vertex i with path compression.
     *
     * @param i Node whose root is to be found.
     * @param parent Parent array.
     * @return The root of the set containing node i.
     */
    private int find(int i, int[] parent) {
        if (parent[i] != i) {
            parent[i] = find(parent[i], parent); // Path compression
        }
        return parent[i];
    }

    /**
     * Unites the sets containing u and v using union by rank.
     *
     * @param u First node.
     * @param v Second node.
     * @param parent Parent array.
     * @param rank Rank array representing tree height upper bounds.
     * @return True if merged successfully; false if u and v were already in the same set.
     */
    private boolean union(int u, int v, int[] parent, int[] rank) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);

        if (rootU == rootV) {
            return false; // Cycle detected
        }

        // Union by rank: attach smaller rank tree under root of higher rank tree
        if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }

        return true;
    }
}
