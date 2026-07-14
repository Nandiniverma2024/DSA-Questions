class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                if(i==j){ // check for primary diagonal
                    if(grid[i][j]==0){
                        return false;
                    }
                }else if(i+j==n-1 && i!=j){ //check for secondary diagonal
                    if(grid[i][j]==0){
                        return false;
                    }
                }else{ //check for non-diagonal el
                    if(grid[i][j]!=0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}