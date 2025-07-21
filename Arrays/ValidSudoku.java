package Arrays;


import java.util.*;
class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        // cover rule 1 and rule 2
        Map<String, Set<Character>> sqMap = new HashMap<>();
        for(int i=0;i<9;i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            for(int j=0;j<9;j++) {
                if(board[i][j] != '.') {
                    if(!row.add(board[i][j])){
                        return false;
                    }

                    String sqKey = (i/3)+","+(j/3);
                    if(sqMap.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(board[i][j]))return false;
                    sqMap.get(sqKey).add(board[i][j]);

                }

                if(board[j][i] != '.'&& !col.add(board[j][i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] arr = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                arr[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println(isValidSudoku(arr));
    }
}
