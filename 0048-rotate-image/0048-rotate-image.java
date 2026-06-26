class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        // Transpose Matrix
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                swap(matrix, i, j, j, i);
            }
        }
        // Reverse Each Row
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){ //if n=3, j<1 , i.e j runs till j=0
                swap(matrix, i, j, i, n-j-1); //n-j-1 => gives last index of each row
            }
        }
    }
    public void swap(int matrix[][], int i1, int j1, int i2, int j2){
        int temp=matrix[i1][j1];
        matrix[i1][j1]=matrix[i2][j2];
        matrix[i2][j2]=temp;
    }
}

// Rotation = Transpose + Horizontal Flip(rotate each row)
