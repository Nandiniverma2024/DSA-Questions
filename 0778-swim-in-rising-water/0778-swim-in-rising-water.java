class Solution {
    class Tuple{
        int row;
        int col;
        int time;
        Tuple(int row, int col, int time){
            this.row=row;
            this.col=col;
            this.time=time;
        }
    }
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)-> Integer.compare(a.time, b.time));

        boolean vis[][]=new boolean[n][n];
        int dr[]={-1, 1, 0, 0};
        int dc[]={0, 0, -1, 1};
       
        pq.offer(new Tuple(0,0, grid[0][0]));
        vis[0][0]=true;

        while(!pq.isEmpty()){
            Tuple tuple=pq.poll();
            int r=tuple.row;
            int c=tuple.col;
            int time=tuple.time;

            if(r==n-1 && c==n-1){
                return time;
            }

            for(int i=0; i<4; i++){
                int nr=r+dr[i];
                int nc=c+dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<n && !vis[nr][nc]){
                    vis[nr][nc]=true;

                    int newTime=Math.max(time, grid[nr][nc]);

                    pq.offer(new Tuple(nr, nc, newTime));
                }
            }
        }

        return -1;
    }
}