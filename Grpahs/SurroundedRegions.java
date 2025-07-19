/*
You are given a 2-D matrix board containing 'X' and 'O' characters.
If a continous, four-directionally connected group of 'O's is surrounded by 'X's, it is considered to be surrounded.
Change all surrounded regions of 'O's to 'X's and do so in-place by modifying the input board.

Example 1:
Input: board = [
  ["X","X","X","X"],
  ["X","O","O","X"],
  ["X","O","O","X"],
  ["X","X","X","O"]
]

Output: [
  ["X","X","X","X"],
  ["X","X","X","X"],
  ["X","X","X","X"],
  ["X","X","X","O"]
]
Explanation: Note that regions that are on the border are not considered surrounded regions.

Constraints:
1 <= board.length, board[i].length <= 200
board[i][j] is 'X' or 'O'.
*/

class SurroundedRegions {
    /* 
    Intuition: find connected regions to the border, 
    since they can't be considered surrounded

    Time Complexity: O(m*n)
    Space Complexity: O(m*n)
    */
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        for(int i=0;i<row;i++) {
            dfs(board, i, 0);
            dfs(board, i, col-1);
        }

        for(int j=0;j<col;j++) {
            dfs(board, 0, j);
            dfs(board, row-1, j);
        }

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs (char[][] board, int r, int c) {
        if(r<0 || c<0 || r>= board.length || c>=board[0].length 
            || board[r][c]=='X' || board[r][c]=='#') {
            return;
        }

        board[r][c] = '#';
        dfs(board, r, c+1);
        dfs(board, r+1, c);
        dfs(board, r-1, c);
        dfs(board, r, c-1);
    }
}
