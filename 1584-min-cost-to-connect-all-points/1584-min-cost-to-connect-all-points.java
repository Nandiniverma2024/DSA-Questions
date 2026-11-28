class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node, int wt){
            this.node=node;
            this.wt=wt;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;

        // Build Graph
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        // assign empty array list to all nodes
        for(int i=0; i<n; i++){ 
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j){
                    continue;
                }

                int a[]=points[i];
                int b[]=points[j];
                int d=Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
                // graph => where every node connect to evry other nodes
                adj.get(i).add(new int[]{j, d});
                adj.get(j).add(new int[]{i, d});
            }
        }

        // Now apply prim's to find MST from graph
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> Integer.compare(a.wt, b.wt));
        pq.offer(new Pair(0,0));

        boolean vis[]=new boolean[n];
        int sum=0;
        
        while(!pq.isEmpty()){
            Pair pair=pq.poll();

            int u=pair.node;
            int wt=pair.wt;

            if(vis[u]){
                continue;
            }

            vis[u]=true;
            sum+=wt;

            for(int num[]:adj.get(u)){
                int v=num[0];
                int w=num[1];

                if(!vis[v]){
                    pq.offer(new Pair(v, w));
                }
            }
        }
        return sum;
    }
}