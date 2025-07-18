/*
You are given a 2-D matrix grid. Each cell can have one of three possible values:

0 representing an empty cell
1 representing a fresh fruit
2 representing a rotten fruit
Every minute, if a fresh fruit is horizontally or vertically adjacent to a rotten fruit, then the fresh fruit also becomes rotten.

Return the minimum number of minutes that must elapse until there are zero fresh fruits remaining. If this state is impossible within the grid, return -1.

Example 1:



Input: grid = [[1,1,0],[0,1,1],[0,1,2]]

Output: 4
Example 2:

Input: grid = [[1,0,1],[0,2,0],[1,0,1]]

Output: -1
Constraints:

1 <= grid.length, grid[i].length <= 10
*/

class RottingFruits {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int freshFruits = 0;
        int resultTime = 0;

        for(int r=0;r<grid.length;r++) {
            for(int c=0;c<grid[0].length;c++) {
                if(grid[r][c] == 1) {
                    freshFruits++;
                }
                if(grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                }
            }
        }
        int[][] directions = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};

        while(freshFruits > 0 && !q.isEmpty()) {
            int len = q.size();
            for(int i=0;i<len;i++) {
                int[] curr = q.poll();
                int r = curr[0], c = curr[1];
                
                // check for neighboring fresh fruits
                for(int[] dir: directions) {
                    int row = r+dir[0], col = c+dir[1];
                    if(row>=0 && row<grid.length &&
                    col>=0 && col<grid[0].length && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        freshFruits--;
                        q.offer(new int[]{row, col});
                    }
                }
            }
            // since one rotten has infected all neighbors, time elapsed a level
            resultTime++;
        }
        return freshFruits == 0 ? resultTime : -1;
    }
}
