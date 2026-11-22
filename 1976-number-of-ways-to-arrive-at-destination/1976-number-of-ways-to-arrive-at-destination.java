class Solution {
    class Pair{
        long dis;
        int node;
        Pair(long dis, int node){
            this.dis=dis;
            this.node=node;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        // Step1: Build Graph
        for(int i=0; i<roads.length; i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int wt=roads[i][2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        // Step2: build dis and ways array
        long dis[]=new long[n];
        int ways[]=new int[n];

        Arrays.fill(dis, Long.MAX_VALUE);

        dis[0]=0;
        ways[0]=1;

        int mod=1_000_000_007;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> Long.compare(a.dis, b.dis));

        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair pair=pq.poll();

            long d=pair.dis;
            int node=pair.node;

            for(int num[]:adj.get(node)){
                int neigh=num[0];
                int wt=num[1];

                if(d+wt<dis[neigh]){
                    dis[neigh]=d+wt;
                    pq.offer(new Pair(dis[neigh], neigh));
                    ways[neigh]=ways[node];
                }else if(d+wt == dis[neigh]){
                    ways[neigh]=(ways[neigh]+ways[node])%mod;
                }
            }
        }
        return ways[n-1];
    }
}