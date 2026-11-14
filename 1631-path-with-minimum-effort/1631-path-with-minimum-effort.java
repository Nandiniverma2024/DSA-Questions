class Solution {
    class Tuple{
        int effort;
        int row;
        int col;
        Tuple(int effort, int row, int col){
            this.effort=effort;
            this.row=row;
            this.col=col;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;

        int dis[][]=new int[n][m];

        for(int i=0; i<n; i++){
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }

        dis[0][0]=0;

        PriorityQueue<Tuple> q = new PriorityQueue<>((a,b) -> a.effort-b.effort);
       

        q.offer(new Tuple(0, 0, 0));

        int dr[]={-1, 1, 0, 0};
        int dc[]={0, 0, -1, 1};

        while(!q.isEmpty()){
            Tuple tuple=q.poll();

            int effort=tuple.effort;
            int row=tuple.row;
            int col=tuple.col;

            if(row==n-1 && col==m-1){
                return effort;
            }

            for(int i=0; i<4; i++){
                int nr=row+dr[i];
                int nc=col+dc[i];


                // when cell already have some val
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    // when cell have infity value
                    int newEffort=Math.max(effort, Math.abs(heights[nr][nc] - heights[row][col]));
                    if(dis[nr][nc]>newEffort){
                        dis[nr][nc]=newEffort;
                        q.offer(new Tuple(newEffort, nr, nc));
                    }
                }
            }
        }
        return 0;
    }
}