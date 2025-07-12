/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard so that no two queens can attack each other.
A queen in a chessboard can attack horizontally, vertically, and diagonally.
Given an integer n, return all distinct solutions to the n-queens puzzle.
Each solution contains a unique board layout where the queen pieces are placed. 'Q' indicates a queen and '.' indicates an empty space.
You may return the answer in any order.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There are two different solutions to the 4-queens puzzle.

Example 2:
Input: n = 1
Output: [["Q"]]

Constraints:
1 <= n <= 8

*/

class N_Queens {
  // Time: O(n!)
  // Space: O(n^2)
    List<List<String>> res;
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        board = new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                board[i][j] = '.';
            }
        }
        placeQueens(0, n);
        return res;
    }

    private void placeQueens(int i, int n) {
        if(i >= n) {
            List<String> currRes = new ArrayList<>();
            for(char[] row: board) {
                currRes.add(String.valueOf(row));
            }
            res.add(currRes);
            return;
        }

        for(int k=0;k<n;k++){
            if(isSafe(i,k,n)) {
                board[i][k] = 'Q';
                placeQueens(i+1, n);
                board[i][k] = '.';
            }
        }
    }

    private boolean isSafe(int r, int c, int n) {
        // check straight above on head
        for(int i=0;i<r;i++) {
            if (board[i][c] == 'Q')return false;
        }

        // check left diagonal
        for(int i=r,j=c;i>=0&&j>=0;i--,j--){
            if(board[i][j] == 'Q')return false;
        }

        // check right diagonal
        for(int i=r,j=c;i>=0 && j<n;i--,j++) {
            if(board[i][j] == 'Q')return false;
        }

        return true;
    }
}
