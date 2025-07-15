/*
You are given a matrix grid where grid[i] is either a 0 (representing water) or 1 (representing land).
An island is defined as a group of 1's connected horizontally or vertically. You may assume all four edges of the grid are surrounded by water.
The area of an island is defined as the number of cells within the island.
Return the maximum area of an island in grid. If no island exists, return 0.

Example 1:
Input: grid = [
  [0,1,1,0,1],
  [1,0,1,0,1],
  [0,1,1,0,1],
  [0,1,0,0,1]
]

Output: 6
Explanation: 1's cannot be connected diagonally, so the maximum area of the island is 6.

Constraints:
1 <= grid.length, grid[i].length <= 50
*/

class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                int[] currArea = new int[1];
                dfs(grid, i, j, currArea);
                area = Math.max(area, currArea[0]);
            }
        }

        return area;
    }

    private void dfs(int[][] grid, int i, int j, int[] currArea) {
        if (grid[i][j] == 0)return;

        grid[i][j] = 0;
        currArea[0] += 1;
        if(i>0) dfs(grid, i-1, j, currArea);
        if(j>0) dfs(grid, i, j-1, currArea);
        if(i<grid.length-1) dfs(grid, i+1, j, currArea);
        if(j<grid[0].length-1) dfs(grid, i, j+1, currArea);
    }
}
