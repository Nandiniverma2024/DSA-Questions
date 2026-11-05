class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n]; 

        // Fill clr array with -1
        Arrays.fill(color, -1);
        for(int i=0; i<n; i++){
            if(color[i]==-1){
                // dfs(i, 0, color, graph)==false -> ye false tb dega jb adj pr same val hogi
                if(dfs(i, 0, color, graph)==false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int node, int clr, int color[], int graph[][]){
        color[node]=clr;
        // graph[node] => give list present on that idx
        for(int adj : graph[node]){
            if(color[adj]==-1){
                if(dfs(adj, 1-clr, color, graph)==false){
                    return false;
                } 
            }else if(color[adj]==clr){ // same clr on adj node is not allowed
                return false;
            }
        }
        return true;
    }
}