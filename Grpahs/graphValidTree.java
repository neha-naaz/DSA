/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
write a function to check whether these edges make up a valid tree.

Example 1:
Input:
n = 5
edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
Output:
true

Example 2:
Input:
n = 5
edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
Output:
false

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] 
and thus will not appear together in edges.

Constraints:
1 <= n <= 100
0 <= edges.length <= n * (n - 1) / 2
*/

class graphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
             graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> vis = new HashSet<>();
        if (!dfs(graph, 0, -1, vis)) {
            return false;
        }
        return vis.size() == n;
    }

    private boolean dfs( List<List<Integer>> graph, int node, int parent, Set<Integer> vis) {
        if (vis.contains(node)) {
            return false;
        }

        vis.add(node);
        for(int child: graph.get(node)) {
            if(child == parent) continue;
            if (!dfs(graph, child, node, vis)) {
                return false;
            }
        }
        return true;
    }

    public boolean validTreeBFS(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
             graph.get(edge[1]).add(edge[0]);
        }
        Queue<int[]> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        q.offer(new int[]{0, -1});
        set.add(0);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int child: graph.get(curr[0])) {
                if (child == curr[1]) continue;
                if (set.contains(child)) return false;
                set.add(child);
                q.offer(new int[]{child, curr[0]});
            }
        }
        return set.size() == n;
    }
}
