class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n]; 

        // Fill clr array with -1
        Arrays.fill(color, -1);
        for(int i=0; i<n; i++){
            if(color[i]==-1){ // you just started
                // dfs(i, 0, color, graph)==false -> ye false tb dega jb adj pr same val hogi
                if(dfs(i, 0, color, graph)==false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int node, int clr, int color[], int graph[][]){
        color[node]=clr; //curr node/idx ko color kr do
        // graph[node] => give list present on that idx
        for(int adj : graph[node]){
            if(color[adj]==-1){ //agr clr na h to clr fill kr dia
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