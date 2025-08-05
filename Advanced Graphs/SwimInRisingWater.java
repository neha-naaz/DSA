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

    
}
