/*
Given a 2-D grid of characters board and a string word, return true if the word is present in the grid, otherwise return false.
For the word to be present it must be possible to form it with a path in the board with horizontally or vertically neighboring cells. 
The same cell may not be used more than once in a word.

Example 1:
Input: 
board = [
  ["A","B","C","D"],
  ["S","A","A","T"],
  ["A","C","A","E"]
],
word = "CAT"
Output: true

Example 2:
Input: 
board = [
  ["A","B","C","D"],
  ["S","A","A","T"],
  ["A","C","A","E"]
],
word = "BAT"
Output: false

Constraints:
1 <= board.length, board[i].length <= 5
1 <= word.length <= 10
board and word consists of only lowercase and uppercase English letters.
*/
class WordSearch {
  // Time Complexity: O(m * 4^n)
  // m is number of cells, n is word length
  // space complecity: O(n)
    public boolean exist(char[][] board, String word) {
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++) {
                if (board[i][j] == word.charAt(0) && helper(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        // dummy statement
        return false;
    }

    private boolean helper(char[][] board, String word, int ind, int r, int c) {
        // out of bounds
        if (ind >= word.length()) {
            return true;
        }

        if (r >= board.length || c >= board[0].length || r < 0 || c < 0) {
            return false;
        }

        if (board[r][c] != word.charAt(ind) || board[r][c] == '.') {
            return false;
        }

        char ch = board[r][c];
        board[r][c] = '.';
        boolean res = helper(board, word, ind+1, r+1, c) || 
        helper(board, word, ind+1, r-1, c) || helper(board, word, ind+1, r, c+1) ||
        helper(board, word, ind+1, r, c-1);
        board[r][c] = ch;

        return res;
    }
}
