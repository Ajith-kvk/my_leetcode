class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        //traverse through first row
        for(int j=0; j<n; j++) {
            if(matrix[0][j] == 0) {
                firstRow = true;
                break;
            }
        }
        //traverse through first col
        for(int i=0; i<m; i++) {
            if(matrix[i][0] == 0) {
                firstCol = true;
                break;
            }
        }
        //mark row and col
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //fill based on the marker
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRow) {
            for(int j=0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }
        if(firstCol) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}