class Solution {//comment
    class Pair{
        int i;
        int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int res[][] = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                res[i][j] = -1;
            }
        }

        Queue<Pair> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 0) {
                    q.offer(new Pair(i, j));
                    res[i][j]=0;
                }
            }
        }

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int row = pair.i;
            int col = pair.j;

            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            for(int k = 0; k < 4; k++) {
                int nr = row + dr[k];
                int nc = col + dc[k];

                 if(nr >= 0 && nr < n && nc >=0 && nc < m && res[nr][nc] == -1) {
                    q.offer(new Pair(nr, nc));
                    res[nr][nc] = res[row][col] + 1;
                 }
            }
        }
        return res;
    }
}