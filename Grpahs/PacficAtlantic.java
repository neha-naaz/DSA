/*
You are given a rectangular island heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
The islands borders the Pacific Ocean from the top and left sides, and borders the Atlantic Ocean from the bottom and right sides.
Water can flow in four directions (up, down, left, or right) from a cell to a neighboring cell with height equal or lower. Water can also flow into the ocean from cells adjacent to the ocean.
Find all cells where water can flow from that cell to both the Pacific and Atlantic oceans. Return it as a 2D list where each element is a list [r, c] representing the row and column of the cell. You may return the answer in any order.

Example 1:
Input: heights = [
  [4,2,7,3,4],
  [7,4,6,4,7],
  [6,3,5,3,6]
]
Output: [[0,2],[0,4],[1,0],[1,1],[1,2],[1,3],[1,4],[2,0]]

Example 2:
Input: heights = [[1],[1]]
Output: [[0,0],[0,1]]

Constraints:
1 <= heights.length, heights[r].length <= 100
0 <= heights[r][c] <= 1000
*/

class PacficAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();

        for(int c=0;c<col;c++) {
            dfs(heights, 0, c, pacific, heights[0][c]);
            dfs(heights, row-1, c, atlantic, heights[row-1][c]);
        }

        for(int r=0;r<row;r++) {
            dfs(heights, r, 0, pacific, heights[r][0]);
            dfs(heights, r, col-1, atlantic, heights[r][col-1]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                List<Integer> curr = new ArrayList<>(Arrays.asList(i, j));
                if (pacific.contains(curr) && atlantic.contains(curr)) {
                    res.add(curr);
                }
            }
        }
        return res;
    }

    private void dfs (int[][] heights, int r, int c, Set<List<Integer>> vis, int prevH) {
        if (r<0 || c<0 || r>=heights.length || c>=heights[0].length 
        || heights[r][c] < prevH || vis.contains(Arrays.asList(r, c))) {
            return;
        }

        vis.add(Arrays.asList(r, c));
        dfs(heights, r+1, c, vis, heights[r][c]);
        dfs(heights, r, c+1, vis, heights[r][c]);
        dfs(heights, r-1, c, vis, heights[r][c]);
        dfs(heights, r, c-1, vis, heights[r][c]);
    }
}
