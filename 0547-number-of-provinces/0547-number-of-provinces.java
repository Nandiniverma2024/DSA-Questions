class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean visited[]=new boolean[n];
        int ans=0;
        // Ans number of prvences ko track krne ke lia use ho rha h
        for(int i=0; i<n; i++){
            if(!visited[i]){
               dfs(i, isConnected, visited); 
               ans++;
            }
        }
        return ans;
    } 

    // dfs m current row, apne se connected sare neghbours ki row pr jake unhe visit kr rha h, or unka ek provences bna rha h
    public void dfs(int i, int[][] isConnected, boolean visited[]){
        int n=isConnected.length;
        visited[i]=true;
        for(int j=0; j<n; j++){
            if(isConnected[i][j]==1 && !visited[j]){
                dfs(j, isConnected, visited);
            }
        }
    }
}