class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        boolean visited[][]=new boolean[n][m];
        // Step1: find all bounday 0's, then find all connected 0's to boundary

        // (i) find all boundary row and their connected 0's
        for(int col=0; col<m; col++){
            // 1st row
            if(!visited[0][col] && board[0][col]=='O'){
                dfs(visited, board, 0, col);
            }
            // last row
            if(!visited[n-1][col] && board[n-1][col]=='O'){
                dfs(visited, board, n-1, col);
            }
        }
        // (ii) find all boundary col and their connected 0's
        for(int row=0; row<n; row++){
            // 1st col
            if(!visited[row][0] && board[row][0]=='O'){
                dfs(visited, board, row, 0);
            }
            // last col
            if(!visited[row][m-1] && board[row][m-1]=='O'){
                dfs(visited, board, row, m-1);
            }
        }

        // iske bad jo 0's bachnge vo sari X se sarround hongi or vo X m convert ho jayngi
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    board[i][j]='X';   
                }
            }
        }
    }

    public void dfs(boolean visited[][], char board[][], int i, int j){
        int n=board.length;
        int m=board[0].length;

        if(i<0 || i>=n || j<0 || j>=m || visited[i][j] || board[i][j]=='X'){
            return;
        }

        visited[i][j]=true;

        dfs(visited, board, i-1, j);
        dfs(visited, board, i+1, j);
        dfs(visited, board, i, j-1);
        dfs(visited, board, i, j+1);
    }
}