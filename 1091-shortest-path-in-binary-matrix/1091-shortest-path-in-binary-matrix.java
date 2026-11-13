class Solution {
    class Pair{
        int dis;
        Cell cell;
        Pair(int dis, Cell cell){
            this.dis=dis;
            this.cell=cell;
        }
    }
    class Cell{
        int row;
        int col;
        Cell(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        // Base Case
        if(grid[0][0]==1 || grid[n-1][m-1]==1){
            return -1;
        }
        
        Queue<Pair> q=new ArrayDeque<>();

        int dist[][]=new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[0][0]=1;

        q.offer(new Pair(1, new Cell(0, 0)));

        // up, down, left, right, upper left, upper right, down left, down right
        int dr[]={-1, 1, 0, 0, -1, -1, 1, 1};
        int dc[]={0, 0, -1, 1, -1, 1, -1, 1};

        while(!q.isEmpty()){
            Pair pair=q.poll();
            int dis=pair.dis;
            int row=pair.cell.row;
            int col=pair.cell.col;

            if(row==n-1 && col==m-1){
                return dis;
            }

            for(int i=0; i<8; i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m && 
                grid[nr][nc]==0 && dist[nr][nc]>dis+1){
                    dist[nr][nc]=dis+1;
                    q.offer(new Pair(dist[nr][nc], new Cell(nr, nc)));
                }
            }
        }
        return -1;
    }
}