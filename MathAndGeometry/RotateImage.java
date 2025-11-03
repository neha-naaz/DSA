class RotateImage {
    /* Intuition: if we observe the positions of the elements after rotate
    result is first vertically flip each column and then transpose the matrix
    Time Complexity: O(n*n)
    Space Complexity: O(1)
    */
    public void rotate(int[][] matrix) {
        // reverse rows
        int n = matrix.length;
        for(int i=0;i<n/2;i++) {
            int[] temp = matrix[i];
            matrix[i] = matrix[n-1-i];
            matrix[n-1-i] = temp;
        }  

        //transposing the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
