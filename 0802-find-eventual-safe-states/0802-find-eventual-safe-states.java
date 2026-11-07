class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;

        // Step1: Build a reverse graph(a graph with reverse edge)
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

        for(int i=0; i<n; i++){ // fill every node with empty arrayList
            adj.add(new ArrayList<>());
        }

        // Cal outDegree and cal. reverse edges
        int outDegree[]=new int[n];
        for(int i=0; i<n; i++){
            // graph[i].length => ye neighbour list da dega with uski length
            outDegree[i]=graph[i].length;

            // cal reverse edges
            for(int j=0; j<graph[i].length; j++){
                int neighNode=graph[i][j]; // 0th row ka 0th col or neigh

                //node(reverse graph jo ki khud neigh h original graph ke nodes ki)ki khali list m neigh(jo ki actual node h original graph m) dal dia
                // reverse direction of edges
                adj.get(neighNode).add(i); //change direction of original node
            }
        }

        ArrayDeque<Integer> q=new ArrayDeque<>();
        for(int i=0; i<n; i++){
            if(outDegree[i]==0){
                q.offer(i);
            }
        }

        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int curr=q.poll();
            res.add(curr);

            for(int neigh:adj.get(curr)){
                outDegree[neigh]--;
                if(outDegree[neigh]==0){
                    q.offer(neigh);
                }
            }
        }

        Collections.sort(res);

        return res;
    }
}