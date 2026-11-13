class Solution {
    class Tuple{
        int city;
        int cost;
        int stops;
        Tuple(int city, int cost, int stops){
            this.city=city;
            this.cost=cost;
            this.stops=stops;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        // Step1: Build Graph
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<flights.length; i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int wt=flights[i][2];

            adj.get(u).add(new int[]{v, wt});
        }

        int dist[]=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src]=0;

        Queue<Tuple> q=new ArrayDeque<>();
        // city, cost, stops
        q.offer(new Tuple(src, 0, -1));

        while(!q.isEmpty()){
            Tuple tuple=q.poll();

            int u=tuple.city;
            int cost=tuple.cost;
            int stops=tuple.stops;

            for(int num[]:adj.get(u)){
                int v=num[0];
                int wt=num[1];

                if(dist[v]>cost+wt && stops+1<=k){
                    dist[v]=cost+wt;
                    q.offer(new Tuple(v, dist[v], stops+1));
                }
            }
        }

        if(dist[dst]==Integer.MAX_VALUE){
            return -1;
        }

        return dist[dst];
    }
}