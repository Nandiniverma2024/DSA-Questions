class Solution {
    class Pair{
        int dis;
        int node;
        Pair(int dis, int node){
            this.dis=dis;
            this.node=node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<times.length; i++){
            int u=times[i][0];
            int v=times[i][1];
            int wt=times[i][2];


            adj.get(u).add(new int[]{v, wt});
        }

        int dis[]=new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        dis[k]=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)-> Integer.compare(a.dis, b.dis));
        pq.offer(new Pair(dis[k], k));

        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int d=pair.dis;
            int u=pair.node;
            if(d > dis[u]) continue;
            for(int neigh[] : adj.get(u)){
                int v=neigh[0];
                int wt=neigh[1];

                if(dis[v]>dis[u]+wt){
                    dis[v]=dis[u]+wt;
                    pq.offer(new Pair(dis[v], v));
                }

            }
        }

        int max=0;
        for(int i=1; i<dis.length; i++){
            max=Math.max(dis[i], max);
        }

        if(max!=Integer.MAX_VALUE){
            return max;
        }

        return -1;
    }
}