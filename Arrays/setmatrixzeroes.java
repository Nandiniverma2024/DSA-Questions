// 73. Set Matrix Zeroes

// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.


// BruteForce Appraoch

class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        // Step 1: Traverse the matrix and mark the cells with a special value when zero is found
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // Mark the entire row and column with a special value (-1e9)
                    for (int k = 0; k < m; k++) {
                        if (matrix[i][k] != 0) matrix[i][k] = -1000000000;
                    }
                    for (int k = 0; k < n; k++) {
                        if (matrix[k][j] != 0) matrix[k][j] = -1000000000;
                    }
                }
            }
        }

        // Step 2: Replace all special values with 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1000000000)
                    matrix[i][j] = 0;
            }
        }
    }
}


// 🧠 TC: O(n²)
// 📦 SC: O(1) (ignoring special marker usage)




// Better Approach
class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        // Step 1: Create row and col marker arrays
        int[] row = new int[n];
        int[] col = new int[m];

        // Step 2: Mark rows and cols where 0s are found
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        // Step 3: Traverse again and set cell to 0 if it's in marked row or col
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || col[j] == 1)
                    matrix[i][j] = 0;
            }
        }
    }
}



// 🧠 TC: O(n x m)
// 📦 SC: O(n + m)



// Optimal Appraoch

class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        boolean rowMarker=false, colMarker=false;
    // Check if originally any 0 present in row and col. marker
        for(int j=0; j<m; j++){
            if(matrix[0][j]==0){
                rowMarker=true;
                break;
            }
        }
        for(int i=0; i<n; i++){
            if(matrix[i][0]==0){
                colMarker=true;
                break;
            }
        }
    // Check inner matrix for 0,mark row and colMarker accordingly
        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
    // Make entire row and col. 0 acc. to row and colmarker 0 val.
        // make entire col 0, acc. to rowmarker
        for(int j=1; j<m; j++){
            if(matrix[0][j]==0){
                for(int i=1;i<n;i++){
                    matrix[i][j]=0;
                }
            }
        }
        // make entire row 0, acc. to colmarker
        for(int i=1; i<n; i++){
            if(matrix[i][0]==0){
                for(int j=1;j<m;j++){
                    matrix[i][j]=0;
                }
            }
        }
    // Make entire row and col marker 0 , if there is any 0 present in them
        if(rowMarker){
            for(int j=0; j<m; j++){
                matrix[0][j]=0;
            }
        }
        if(colMarker){
            for(int i=0; i<n; i++){
                matrix[i][0]=0;
            }
        }
    }
}

// 🧠 TC: O(n × m)
// 📦 SC: O(1) — no extra space used

