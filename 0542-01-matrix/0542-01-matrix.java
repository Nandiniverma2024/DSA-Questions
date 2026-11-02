class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int res[][]=new int[n][m];

        // Fill res mat with -1
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                res[i][j]=-1;
            }
        }

        Queue<Pair> q=new ArrayDeque<>();

        // if cell have val 0 then put 0 in res matrix
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i,j));
                    res[i][j]=0;
                }
            }
        }

        // up down left right
        int dr[]={-1, 1, 0, 0};
        int dc[]={0, 0, -1, 1};

        while(!q.isEmpty()){
            Pair pair=q.poll();
            int row=pair.i;
            int col=pair.j;

            // go in all directions and find new row and new col
            for(int k=0; k<4; k++){
                int nr=row+dr[k];
                int nc=col+dc[k];

                // cell must be in bpundary and not visited
                if(nr>=0 && nr<n && nc>=0 && nc<m && res[nr][nc]==-1){
                    res[nr][nc]=res[row][col]+1;
                    q.offer(new Pair(nr, nc));
                }
            }
        }

        return res;
    }
}