class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    class PairTime{
        Pair pair;
        int time;
        PairTime(Pair pair, int time){
            this.pair=pair;
            this.time=time;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<PairTime> q=new ArrayDeque<>();
        int ans=0;
        // pair=> (i,j) => track my node
        // Integer => Track time
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    q.offer(new PairTime(new Pair(i,j), 0));
                }
            }
        }

        while(!q.isEmpty()){
            PairTime pt=q.poll();
            Pair p=pt.pair;
            int r=p.row;
            int c=p.col;
            int time=pt.time;

            ans=Math.max(ans, time);

            // Check for 4 adjacent directions
            // left
            if(r-1>=0 && !visited[r-1][c] && grid[r-1][c]==1){
                q.offer(new PairTime(new Pair(r-1, c), time+1));
                visited[r-1][c]=true;
                grid[r-1][c]=2;
            }
            // up
            if(c-1>=0 && !visited[r][c-1] && grid[r][c-1]==1){
                q.offer(new PairTime(new Pair(r, c-1), time+1));
                visited[r][c-1]=true;
                grid[r][c-1]=2;
            }
            // down
            if(c+1<m && !visited[r][c+1] && grid[r][c+1]==1){
                q.offer(new PairTime(new Pair(r, c+1), time+1));
                visited[r][c+1]=true;
                grid[r][c+1]=2;
            }
            // right
            if(r+1<n && !visited[r+1][c] && grid[r+1][c]==1){
                q.offer(new PairTime(new Pair(r+1, c), time+1));
                visited[r+1][c]=true;
                grid[r+1][c]=2;
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