class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;

        int res[][]=new int[n][m];
        for(int i=0; i<n; i++){
            Arrays.fill(res[i], -1);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isWater[i][j]==1){
                    res[i][j]=0;
                }
            }
        }

        Queue<Pair> q=new ArrayDeque<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(res[i][j]==0){
                    q.offer(new Pair(i, j));
                }
            }
        }

        int dr[]={-1, 1, 0, 0};
        int dc[]={0, 0, -1, 1};

        while(!q.isEmpty()){
            Pair pair=q.poll();
            int r=pair.r;
            int c=pair.c;

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