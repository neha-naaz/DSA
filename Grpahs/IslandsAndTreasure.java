/*
You are given a 
m
×
n
m×n 2D grid initialized with these three possible values:

-1 - A water cell that can not be traversed.
0 - A treasure chest.
INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest then the value should remain INF.

Assume the grid can only be traversed up, down, left, or right.

Modify the grid in-place.

Example 1:

Input: [
  [2147483647,-1,0,2147483647],
  [2147483647,2147483647,2147483647,-1],
  [2147483647,-1,2147483647,-1],
  [0,-1,2147483647,2147483647]
]

Output: [
  [3,-1,0,1],
  [2,2,1,-1],
  [1,-1,2,-1],
  [0,-1,3,4]
]
Example 2:

Input: [
  [0,-1],
  [2147483647,2147483647]
]

Output: [
  [0,-1],
  [1,2]
]
Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 100
grid[i][j] is one of {-1, 0, 2147483647}

*/

class IslandsAndTreasure {
    private int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    private final int INF = 2147483647;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 0) {
                    // Enque all treasure sources
                    que.offer(new int[]{i,j});
                }
            }
        }
        if (que.size() == 0) return;

        while(!que.isEmpty()) {
            // traverse from all sources simultaneously
            int curr[] = que.poll();
            for(int[] dir: directions) {
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                if(r<0 || c<0 || r>grid.length-1 || c>grid[0].length-1 || grid[r][c] != INF) {
                    continue;
                }
                grid[r][c] = 1+grid[curr[0]][curr[1]];
                que.offer(new int[]{r,c});
            }
        }
    }
}
