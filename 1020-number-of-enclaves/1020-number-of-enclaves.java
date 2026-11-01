class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        boolean visited[][]=new boolean[n][m];

        // Step1: visit boundary 1's of cols
        for(int rows=0; rows<n; rows++){
            // col 0
            if(grid[rows][0]==1){
                dfs(grid, rows, 0, visited); 
            }
            // col n-1
            if(grid[rows][m-1]==1){
                dfs(grid, rows, m-1, visited); 
            }
        }
        // Step2: visit boundary 1's of rows
        for(int cols=0; cols<m; cols++){
            // row 0
            if(grid[0][cols]==1){
                dfs(grid, 0, cols, visited); 
            }
            // row n-1
            if(grid[n-1][cols]==1){
                dfs(grid, n-1, cols, visited); 
            }
        }
        // Step3: cnt 1's inside boundary
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void dfs(int grid[][], int i, int j, boolean visited[][]){
        int n=grid.length;
        int m=grid[0].length;
        // Base Case
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] || grid[i][j]!=1){
            return;
        }
        visited[i][j]=true;
        
        dfs(grid, i-1, j, visited);
        dfs(grid, i+1, j, visited);
        dfs(grid, i, j-1, visited);
        dfs(grid, i, j+1, visited);
    }
}