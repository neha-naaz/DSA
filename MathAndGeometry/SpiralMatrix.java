class SpiralMatrix {
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int l = 0, r = cols, top = 0, bottom = rows;
        List<Integer> result = new ArrayList<>();
        while (l < r && top < bottom) {
            //right
            for(int i=l;i<r;i++) {
                result.add(matrix[top][i]);
            }
            top++;
            //down
            for(int i=top;i<bottom;i++) {
                result.add(matrix[i][r-1]);
            }
            r--;
            if (!(l<r && top<bottom)) {
                break;
            }
            //left
            for(int i=r-1;i>=l;i--) {
                result.add(matrix[bottom-1][i]);
            }
            bottom--;
            //up
            for(int i=bottom-1;i>=top;i--) {
                result.add(matrix[i][l]);
            }
            l++;
        }
        return result;
    }
}
