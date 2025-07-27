/*
You are given a connected undirected graph with n nodes labeled from 1 to n. Initially, it contained no cycles and consisted of n-1 edges.
We have now added one additional edge to the graph. The edge has two different vertices chosen from 1 to n, and was not an edge that 
previously existed in the graph.
The graph is represented as an array edges of length n where edges[i] = [ai, bi] represents an edge between nodes ai and bi in the graph.
Return an edge that can be removed so that the graph is still a connected non-cyclical graph. If there are multiple answers, 
return the edge that appears last in the input edges.

Example 1:
Input: edges = [[1,2],[1,3],[3,4],[2,4]]
Output: [2,4]

Example 2:
Input: edges = [[1,2],[1,3],[1,4],[3,4],[4,5]]
Output: [3,4]

Constraints:
n == edges.length
3 <= n <= 100
1 <= edges[i][0] < edges[i][1] <= edges.length
There are no repeated edges and no self-loops in the input.
*/

class RedundantConnection {
    // Intuition: if the current connecting when connected forms a cycle
    // when traversed in the input order output that
    // Union Find Algorithm
    int[] parent;
    int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length+1;
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for (int[] e: edges) {
            if (!union(e[0], e[1])) {
                return new int[]{e[0], e[1]};
            }
        }
        // dummy
        return new int[]{0, 0};
    }

    private boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if(pa == pb) {
            return false;
        }
        if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
            rank[pa] += rank[pb];
        } else {
            parent[pa] = pb;
            rank[pb] += rank[pa];
        }
        
        return true;
    }

    private int find(int node) {
        int curr = node;
        while(curr != parent[curr]) {
            parent[curr] = parent[parent[curr]];
            curr = parent[curr];
        }
        return curr;
    }
}
