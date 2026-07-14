class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int sum=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // Take sum of primary daigonal
                if(i==j){
                    sum+=mat[i][j];
                }
                // Take sum of Secondary diagonal
                if(i+j==n-1 && i!=j){
                    sum+=mat[i][j];
                }
            }
        }
        return sum;
    }
}