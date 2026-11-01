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
        // pair=> (i,j) => track my node or cell
        // Integer => Track time
        int n=grid.length;
        int m=grid[0].length;
        boolean visited[][]=new boolean[n][m];

        // Add all rotten oranges(different starting point wale sare rotten oranges add kr dia)
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    visited[i][j]=true;
                    q.offer(new PairTime(new Pair(i,j), 0));
                }
            }
        }
        
        int ans=bfs(q, grid, visited, n, m);

        // check fresh oranges(abi bi koi fresh orange bacha h to return -1)
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }

        return ans;
    }

    public int bfs(Queue<PairTime> q, int grid[][], boolean visited[][], int n, int m){
        int ans=0;
        while(!q.isEmpty()){
            PairTime pt=q.poll();
            Pair p=pt.pair;
            int r=p.row;
            int c=p.col;
            int time=pt.time;

            ans=Math.max(ans, time);

            // Check for 4 adjacent directions(and update all freash oranges rotten by changing their value from 1 to 2)
            // left
            if(r-1>=0 && !visited[r-1][c] && grid[r-1][c]==1){
                q.offer(new PairTime(new Pair(r-1, c), time+1));
                visited[r-1][c]=true;
                grid[r-1][c]=2; //make fresh orange rotten
            }
            // up
            if(c-1>=0 && !visited[r][c-1] && grid[r][c-1]==1){
                q.offer(new PairTime(new Pair(r, c-1), time+1));
                visited[r][c-1]=true;
                grid[r][c-1]=2; //make fresh orange rotten
            }
            // down
            if(c+1<m && !visited[r][c+1] && grid[r][c+1]==1){
                q.offer(new PairTime(new Pair(r, c+1), time+1));
                visited[r][c+1]=true;
                grid[r][c+1]=2; //make fresh orange rotten
            }
            // right
            if(r+1<n && !visited[r+1][c] && grid[r+1][c]==1){
                q.offer(new PairTime(new Pair(r+1, c), time+1));
                visited[r+1][c]=true;
                grid[r+1][c]=2; //make fresh orange rotten
            }
        }
        return ans;
    }
}