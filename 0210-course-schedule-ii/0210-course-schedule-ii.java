class Solution {
    public int[] findOrder(int n, int[][] edges) {
        boolean vis[]=new boolean[n];
        boolean recPath[]=new boolean[n];
        int ans[]=new int[n]; 

        for(int i=0; i<n; i++){
            if(!vis[i]){
                // agr cycle exist krti h to return empty array
                if(dfs(i, edges, vis, recPath)){
                    return new int[0]; //kuki upper ans array n size ka define h
                    // to yha khud se 0 size ka bna ke return krna h
                }
            }
        }
        
        Stack<Integer> st=new Stack<>();
        Arrays.fill(vis, false);

        for(int i=0; i<n; i++){
            if(!vis[i]){
                topoOrder(i, st, vis, edges);
            }
        }

        int i=0;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i++;
        }

        return ans;
    }
    public void topoOrder(int src, Stack<Integer> st, boolean vis[], int edges[][]){
        int n=edges.length;
        vis[src]=true;
        for(int i=0; i<n; i++){
            int u=edges[i][1];
            int v=edges[i][0];
            if(u==src){
                if(!vis[v]){
                    topoOrder(v, st, vis, edges);
                }
            }
        }
        st.push(src);
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