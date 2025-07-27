/*
There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b] 
means that there is an edge between node a and node b in the graph.
The nodes are numbered from 0 to n - 1.
Return the total number of connected components in that graph.

Example 1:
Input:
n=3
edges=[[0,1], [0,2]]
Output:
1

Example 2:
Input:
n=6
edges=[[0,1], [1,2], [2,3], [4,5]]
Output:
2

Constraints:
1 <= n <= 100
0 <= edges.length <= n * (n - 1) / 2
*/

class NumberofConnectedComponents {
    // Disjoint Union Set
    // Time: O(V+(E*alpha(V))) Space: O(V)
    int[] rank;
    int[] parent;
    public int countComponents(int n, int[][] edges) {
        rank = new int[n];
        parent = new int[n];
        for(int i=0;i<n;i++) {
            rank[i] = 1;
            parent[i] = i;
        }
        int components = n;
        for (int[] e: edges) {
            if (union(e[0], e[1])) {
                components--;
            }
        }
        return components;
    }

    private boolean union(int a, int b) {
        int pa = findParent(a), pb = findParent(b);
        // if they are already connected
        if (pa == pb) {
            // we dint perform any union
            return false;
        }

        if (rank[pa] > rank[pb]) {
            // connect b to a
            rank[pa] += rank[pb];
            parent[pb] = pa;
        } else {
            rank[pb] += rank[pa];
            parent[pa] = pb;
        }

        return true;
    }

    private int findParent(int node) {
        int curr = node;
        // while we dont find the root parent(node whose parent is itself)
        while (curr != parent[curr]) {
            // traverse up the tree
            parent[curr] = parent[parent[curr]];
            curr = parent[curr];
        }
        return curr;
    }
}
