class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int transpose[][]=new int[m][n];

        // Transpose matrix
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                transpose[j][i]=matrix[i][j];
            }
        }


        // copy values into original matrix
        for(int i=0; i<transpose.length; i++){
            for(int j=0; j<transpose[0].length; j++){
                matrix[j][i]=transpose[j][i];
            }
        }

        // Rotate matrix(reverse each row, by traversing on col)
        // i fix rhega
        for(int i=0; i<m; i++){
            int left=0, right=n-1;
            while(left<=right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;

                left++;
                right--;
            }
        }
    }
}