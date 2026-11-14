class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        // Build Graph
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j]==1 && i!=j){ // 0 la 0 se conenction show ni krna
                    adj.get(i).add(j);
                }
            }
        }

        // Cal ans
        int ans=0;
        boolean visited[]=new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                ans++;
                dfs(i, visited, adj);
            }
        }

        return ans;
    }
    public void dfs(int src, boolean visited[], ArrayList<ArrayList<Integer>> adj){
        visited[src]=true;
        for(int neigh:adj.get(src)){
            if(!visited[neigh]){
                dfs(neigh, visited, adj);
            }
        }
    }
}