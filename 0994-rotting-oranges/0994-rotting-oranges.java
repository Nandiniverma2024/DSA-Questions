class Solution {
    class Tuple{
        int r;
        int c;
        int time;
        Tuple(int r, int c, int time){
            this.r=r;
            this.c=c;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Tuple> q=new ArrayDeque<>();

        boolean vis[][]=new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2 && !vis[i][j]){
                    q.offer(new Tuple(i, j, 0));
                    vis[i][j]=true;
                }
            }
        }

        int dr[]={-1, 1, 0, 0};
        int dc[]={0, 0, -1, 1};

        int ans=0;

        while(!q.isEmpty()){
            Tuple tuple=q.poll();
            int r=tuple.r;
            int c=tuple.c;
            int t=tuple.time;

            ans=Math.max(ans, t);

            for(int i=0; i<4; i++){
                int nr=r+dr[i];
                int nc=c+dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    vis[nr][nc]=true;
                    q.offer(new Tuple(nr, nc, t+1));
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return ans;
    }
}