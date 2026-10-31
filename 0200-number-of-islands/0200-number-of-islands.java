class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];

        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // agr connection exist krta h aur vo cell visited nhi h to dfs call hoga
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(i, j, n, m, grid, visited);
                    ans++;
                }
            }
        }
        return ans;
    }
    // dfs hr cell ke lia uski charo direction m searchj krega
    public void dfs(int i, int j , int n, int m, char grid[][], boolean visited[][]){
        // Base Case
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] || grid[i][j]!='1'){
            return;
        }
        // consider 1 as an edge
        visited[i][j]=true;

        dfs(i+1, j, n, m, grid, visited);
        dfs(i-1, j, n, m, grid, visited);
        dfs(i, j+1, n, m, grid, visited);
        dfs(i, j-1, n, m, grid, visited);
    }
}