/*
You are given a square 2-D matrix of distinct integers grid where each integer grid[i][j] represents the elevation at position (i, j).
Rain starts to fall at time = 0, which causes the water level to rise. At time t, the water level across the entire grid is t.
You may swim either horizontally or vertically in the grid between two adjacent squares if the original elevation of both squares is less 
than or equal to the water level at time t. Starting from the top left square (0, 0), return the minimum amount of time it will take until it 
is possible to reach the bottom right square (n - 1, n - 1).

Example 1:
Input: grid = [[0,1],[2,3]]
Output: 3
Explanation: For a path to exist to the bottom right square grid[1][1] the water elevation must be at least 3. At time t = 3, the water level is 3.

Example 2:
Input: grid = [
  [0,1,2,10],
  [9,14,4,13],
  [12,3,8,15],
  [11,5,7,6]]
]
Output: 8
Explanation: The water level must be at least 8 to reach the bottom right square. The path is [0, 1, 2, 4, 8, 7, 6].

Constraints:
grid.length == grid[i].length
1 <= grid.length <= 50
0 <= grid[i][j] < n^2
*/

class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        return dfs(grid, 0, 0, 0);
    }
  
    // Time Complexity: O(4^n^2)
    // Space Complexity: O(n^2)
    private int naiveDfs(int[][] grid, int i, int j, int currTime) {
        // out of bounds
        if (i < 0 || j < 0 || i > grid.length-1 || j > grid.length-1) {
            return (int) 1e9;
        }

        // already visited
        if (grid[i][j] == -1) return (int) 1e9;

        if (i == grid.length-1 && j==grid.length-1) {
            return Math.max(currTime, grid[i][j]);
        }

        currTime = Math.max(currTime, grid[i][j]);
        int val = grid[i][j];
        grid[i][j] = -1;
        // explore all paths
        int newTime1 = dfs(grid, i+1, j, currTime);
        int newTime2 = dfs(grid, i, j+1, currTime);
        int newTime3 = dfs(grid, i-1, j, currTime);
        int newTime4 = dfs(grid, i, j-1, currTime);
        int result = Math.min(newTime1, newTime2);
        result = Math.min(result, newTime3);
        result = Math.min(result, newTime4);
        // backtrack
        grid[i][j] = val;
        return result;
    }

    // Approach: instead of exploring all paths, and backtrack find 
    // min and max Elevation and check if we could reach dest with that elevation 
    // Time Complexity: O(n^4) Space Complexity: O(n^2)
    public int swimInWater1(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        int minH = grid[0][0], maxH = grid[0][0];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                maxH = Math.max(maxH, grid[row][col]);
                minH = Math.min(minH, grid[row][col]);
            }
        }

        for(int t=minH;t<maxH;t++) {
            if (dfsOptimized(grid, visit, 0, 0, t)) {
                return t;
            }
            for(int r=0;r<n;r++) {
                Arrays.fill(visit[r], false);
            }
        }
        return maxH;
    }

    private boolean dfsOptimized(int[][] grid, boolean[][] visit, int i, int j, int t) {
        if (i<0 || j<0 || i>grid.length-1 || j>grid.length-1 || visit[i][j] || grid[i][j] > t) {
            return false;
        }
        if (i==grid.length-1 && j==grid.length-1) {
            return true;
        }
        visit[i][j] = true;
        return dfsOptimized(grid, visit, i+1, j, t) ||
               dfsOptimized(grid, visit, i-1, j, t) ||
               dfsOptimized(grid, visit, i, j+1, t) ||
               dfsOptimized(grid, visit, i, j-1, t);
    }

    // Approach: instead of looping from minH to maxH, do a binary search 
    // Time Complexity: O(n^2 logn) Space Complexity: O(n^2)
    public int swimInWater2(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        int minH = grid[0][0], maxH = grid[0][0];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                maxH = Math.max(maxH, grid[row][col]);
                minH = Math.min(minH, grid[row][col]);
            }
        }
        int l = minH, r = maxH;
        while (l < r) {
            int m = (l+r)/2;
            if (dfsOptimized1(grid, visit, 0, 0, m)) {
                r = m;
            } else {
                l = m+1;
            }
            for(int i=0;i<n;i++) {
                Arrays.fill(visit[i], false);
            }
        }
        return r;
    }

    private boolean dfsOptimized1(int[][] grid, boolean[][] visit, int i, int j, int t) {
        if (i<0 || j<0 || i>grid.length-1 || j>grid.length-1 || visit[i][j] || grid[i][j] > t) {
            return false;
        }
        if (i==grid.length-1 && j==grid.length-1) {
            return true;
        }
        visit[i][j] = true;
        return dfsOptimized1(grid, visit, i+1, j, t) ||
               dfsOptimized1(grid, visit, i-1, j, t) ||
               dfsOptimized1(grid, visit, i, j+1, t) ||
               dfsOptimized1(grid, visit, i, j-1, t);
    }

    // Dijkstra's algorithm
    //Time Complexity: O(N^2 * log N) – Each of the N^2 cells is pushed into the min-heap at most once.
    // Space Complexity: O(N^2) – for the visited array and the heap.
    public int swimInWater3(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visit[0][0] = true;

        while(!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int t = curr[0], i=curr[1], j=curr[2];
            if (i == n-1 && j==n-1) {
                return t;
            }

            for(int[] dir: directions) {
                int r = dir[0]+i;
                int c = dir[1]+j;
                if (r>=0 && c>=0 && r<n && c<n && !visit[r][c]) {
                    visit[r][c] = true;
                    minHeap.offer(new int[]{Math.max(grid[r][c], t), r, c});
                }
            }
        }
        return n*n;
    }

    // Kruskal's Approach
    // Time Complexity: O(n^2 logn) Space Complexity: O(n^2)
    public int swimInWater4(int[][] grid) {
        int N = grid.length;
        DSU dsu = new DSU(N * N);
        // each cell is considered as vertex
        List<int[]> positions = new ArrayList<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                positions.add(new int[]{grid[r][c], r, c});
            }
        }
        // sort all the positions based on value(weight)
        positions.sort(Comparator.comparingInt(a -> a[0]));
        // all neighbors considered edges
        int[][] directions = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        
        for (int[] pos : positions) {
            int t = pos[0], r = pos[1], c = pos[2];
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < N && nc >= 0 &&
                    nc < N && grid[nr][nc] <= t) {
                    dsu.union(r * N + c, nr * N + nc);
                }
            }
            if (dsu.connected(0, N * N - 1)) return t;
        }
        // dummy statement
        return N * N;
    }
}

class DSU {
    int[] parent;
    int[] rank;
    public DSU(int n) {
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i=0;i<=n;i++) {
            parent[i] = i;
        }
        Arrays.fill(rank, 1);
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        if (rank[pu] < rank[pv]) {
            int temp = rank[pu];
            rank[pu] = rank[pv];
            rank[pv] = temp;
        }
        rank[pu] += rank[pv];
        parent[pv] = pu;
        return true;
    }

    public boolean connected(int u, int v) {
        return find(u) == find(v);
    }
}
