class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length; //row
        int m=matrix[0].length; //col


        int transpose[][]=new int[n][m];
        int o=transpose.length;
        int p=transpose[0].length;

        // Transpose
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                transpose[j][i]=matrix[i][j];
            }
        }

        // Reverse each row
        for(int i=0; i<n; i++){
            int left=0;
            // matrix[i].length => gives length of each row
            int right=transpose[i].length-1;
            while(left<right){
                int temp=transpose[i][left];
                transpose[i][left]=transpose[i][right];
                transpose[i][right]=temp;
                left++;
                right--;
            }
        }
        for(int i=0; i<o; i++){
            for(int j=0; j<p; j++){
                matrix[i][j]=transpose[i][j];
            }
        }
    }
    
}