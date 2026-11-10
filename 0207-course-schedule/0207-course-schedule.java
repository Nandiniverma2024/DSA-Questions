class Solution {
    public boolean canFinish(int n, int[][] edges) {
        boolean vis[]=new boolean[n];
        boolean recPath[]=new boolean[n];
        for(int i=0; i<n; i++){
            if(!vis[i]){
                // agr cycle exist krti h to return false kuki finish nhi ho payga
                if(dfs(i, edges, vis, recPath)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int src, int[][] edges, boolean vis[], boolean recPath[]){
        vis[src]=true;
        recPath[src]=true;
        for(int i=0; i<edges.length; i++){
            int v=edges[i][0];
            int u=edges[i][1]; //dependency
            if(u==src){
                if(!vis[v]){
                    if(dfs(v, edges, vis, recPath)){
                        return true;
                    }
                }else if(recPath[v]){
                    return true;
                }
            }
        }
        recPath[src]=false;
        return false;
    }
}