/*
You are given a 2-D integer array points, where points[i] = [xi, yi]. Each points[i] represents a distinct point on a 2-D plane.
The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between the two points, i.e. |xi - xj| + |yi - yj|.
Return the minimum cost to connect all points together, such that there exists exactly one path between each pair of points.

Example 1:
Input: points = [[0,0],[2,2],[3,3],[2,4],[4,2]]
Output: 10

Constraints:
1 <= points.length <= 1000
-1000 <= xi, yi <= 1000
*/

class MinCostToConnectPoints {
    // Approach: Kruskal's Algo
    // Time complexity: O(n^2 logn) Space: O(n^2)
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        // build edges with weights(manhattan distances)
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = Math.abs(points[i][0] - points[j][0]) + 
                           Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[] {dist, i, j});
            }
        }
        edges.sort((a, b) -> Integer.compare(a[0], b[0]));
        int res = 0;

        for (int[] edge: edges) {
            // no need to check for ycle that we do in kruskal 
            // as points have only one path
            if (dsu.union(edge[1], edge[2])) {
                res += edge[0];
            }
        }

        return res;
    }
}

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        int curr = x;
        if (curr != parent[curr]) {
            parent[curr] = find(parent[curr]);
        }

        return parent[curr];
    }

    public boolean union(int x, int y) {
        int s1 = find(x);
        int s2 = find(y);
        if (s1 != s2) {
            if (rank[s1] < rank[s2]) {
                parent[s1] = s2;
            } else if (rank[s1] > rank[s2]) {
                parent[s2] = s1;
            } else {
                parent[s2] = s1;
                rank[s1] += rank[s2];
            }
            return true;
        }
        return false;
    }
}
