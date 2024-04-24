package Arrays_HashMaps_Strings;
// https://leetcode.com/problems/transpose-matrix/solutions/5069023/transpose-matrix-java-approach-o-n-m-time-o-1-space-explanation/

// Easy
// 2D Array
// Swap row,col with col,row
// T:O(N*M), S:O(1)
// Swap row,col of input with col,row of output

public class TransposeMatrix {
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
