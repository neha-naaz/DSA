public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int ROWS = matrix.length, COLS = matrix[0].length;
        boolean rowZero = false; // Tracks if the first row needs to be zeroed

        // First pass: mark zeros in the first row/col, and remember if row 0 needs zeroing
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = 0; // Mark this column to be zeroed
                    if (r > 0) {
                        matrix[r][0] = 0; // Mark this row to be zeroed
                    } else {
                        rowZero = true; // First row needs to be zeroed
                    }
                }
            }
        }

        // Second pass: zero cells based on marks (skip first row and column for now)
        for (int r = 1; r < ROWS; r++) {
            for (int c = 1; c < COLS; c++) {
                if (matrix[0][c] == 0 || matrix[r][0] == 0) {
                    matrix[r][c] = 0;
                }
            }
        }

        // Zero out the first column if needed
        if (matrix[0][0] == 0) {
            for (int r = 0; r < ROWS; r++) {
                matrix[r][0] = 0;
            }
        }

        // Zero out the first row if needed
        if (rowZero) {
            for (int c = 0; c < COLS; c++) {
                matrix[0][c] = 0;
            }
        }
    }
}
