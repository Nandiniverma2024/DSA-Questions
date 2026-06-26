class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        // Transpose
        for(int i=0; i<n; i++){
            for(int j=i+1; j<m; j++){ //j=>i+1, to preserve diagonal element
                int temp=matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }

        // Reverse each row
        for(int i=0; i<n; i++){
            int left=0;
            int right=matrix[i].length-1;
            while(left<right){
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;

                left++;
                right--;
            }
        }
    }
}