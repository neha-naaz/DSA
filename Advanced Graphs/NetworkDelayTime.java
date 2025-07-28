/*
You are given a network of n directed nodes, labeled from 1 to n. You are also given times, a list of directed edges where times[i] = (ui, vi, ti).
ui is the source node (an integer from 1 to n)
vi is the target node (an integer from 1 to n)
ti is the time it takes for a signal to travel from the source to the target node (an integer greater than or equal to 0).
You are also given an integer k, representing the node that we will send a signal from.
Return the minimum time it takes for all of the n nodes to receive the signal. If it is impossible for all the nodes to receive the signal, return -1 instead.

Example 1:
Input: times = [[1,2,1],[2,3,1],[1,4,4],[3,4,1]], n = 4, k = 1
Output: 3

Example 2:
Input: times = [[1,2,1],[2,3,1]], n = 3, k = 2
Output: -1

Constraints:
1 <= k <= n <= 100
1 <= times.length <= 1000
*/

class NetworkDelayTime {
    // Dijkstra's Algo, Shortest Path 
    // Time Complexity: O(ElogV)
    public int networkDelayTime(int[][] times, int n, int k) {
        Comparator<int[]> cmp = (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        };
        TreeSet<int[]> set = new TreeSet<>(cmp);
        List<List<int[]>> graph = new ArrayList<>();
        boolean[] vis = new boolean[n + 1];

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int[] curr : times) {
            graph.get(curr[0]).add(new int[]{curr[1], curr[2]});
        }

        set.add(new int[]{k, 0});
        int t = 0;
        while (!set.isEmpty()) {
            int[] currNode = set.pollFirst();
            int u = currNode[0];
            t = currNode[1];
            if (vis[u]) continue;
            vis[u] = true;

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int weight = edge[1];
                int newDist = currNode[1] + weight;
                if (!vis[v]) {
                    set.add(new int[]{v, newDist});
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (vis[i] == false) return -1;
        }
        return t;
    }
}
