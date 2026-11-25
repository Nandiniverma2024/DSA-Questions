class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dis[][]=new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        // fill diagonal val with 0
        for(int i=0; i<n; i++){
            dis[i][i]=0;
        }

        // Step1: Build Graph
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];

            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        // Step2: Fill dis Array
        // u=> current city, v=> adj or neighbour city
        for(int u=0; u<n; u++){
            for(int num[]:adj.get(u)){
                int v=num[0];
                int wt=num[1];

                dis[u][v]=wt;
            }
        }

        
        // Step3: Apply flyod warshell algo(update val in dis matrix)
        for(int k=0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(dis[i][k]==Integer.MAX_VALUE || dis[k][j]==Integer.MAX_VALUE){
                        continue;
                    }

                    dis[i][j]=Math.min(dis[i][j], dis[i][k]+dis[k][j]);
                }
            }
        }

        int maxCity=n, cityno=-1;
        // Step4: check for the city having value less than threshold
        for(int i=0; i<n; i++){
            int cnt=0;
            for(int j=0; j<n; j++){
                if(dis[i][j]<=distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=maxCity){
                maxCity=cnt;
                cityno=i;
            }
        }

        return cityno;
    }
}