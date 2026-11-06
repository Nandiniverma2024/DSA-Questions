class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        boolean visited[]=new boolean[n];
        boolean recPath[]=new boolean[n];
        int check[]=new int[n];

        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs(i, check, visited, recPath, graph);
            }
        }

        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0; i<check.length; i++){
            if(check[i]==1){
                res.add(i);
            }
        }

        return res;
    }
    public boolean dfs(int src, int check[], boolean visited[], boolean recPath[], int[][] graph){
        visited[src]=true;
        recPath[src]=true;
        int des[]=graph[src];

        for(int neigh:des){
            if(!visited[neigh]){
                if(dfs(neigh, check, visited, recPath, graph)){
                    return true;
                }
            }else if(recPath[neigh]){
                return true;
            }
        }

        recPath[src]=false;
        check[src]=1;
        return false;
    }
}