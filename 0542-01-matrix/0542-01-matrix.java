class Solution {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int res[][]=new int[n][m];

        // Fill res array with -1
        for(int i=0; i<n; i++){
            Arrays.fill(res[i], -1);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    res[i][j]=0;
                }
            }
        }

        Queue<Pair> q=new ArrayDeque<>();

        // Multi source bfs
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i, j));
                }
            }
        }

        int dr[]={-1, 1, 0, 0};
        int dc[]={0, 0, -1, 1};

        while(!q.isEmpty()){
            Pair pair=q.poll();
            int r=pair.row;
            int c=pair.col;

            for(int i=0; i<4; i++){
                int nr=r+dr[i];
                int nc=c+dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && res[nr][nc]==-1){
                    res[nr][nc]=res[r][c]+1;

                    q.offer(new Pair(nr, nc));
                }
            }
        }

        return res;
    }
}