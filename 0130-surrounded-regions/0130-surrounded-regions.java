class Solution {
    // Algorithm
    // start from the boundary O's & mark them visited so that they will not be converted
    // convert the remaining O's to be 'X'
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean visited[][] = new boolean[n][m];

        for(int col = 0; col < m; col++) {
            // first row
            if(!visited[0][col] && board[0][col] == 'O') {
                dfs(0, col, visited, board);
            }

            // last row
            if(!visited[n-1][col] && board[n-1][col] == 'O') {
                dfs(n-1, col, visited, board);
            }
        }

        for(int row = 0; row < n; row++) {
            // first col
            if(!visited[row][0] && board[row][0] == 'O') {
                dfs(row, 0, visited, board);
            }

            // last col
            if(!visited[row][m-1] && board[row][m-1] == 'O') {
                dfs(row, m-1, visited, board);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i, int j, boolean visited[][], char board[][]) {
        int n = board.length;
        int m = board[0].length;
        // Base Case
        if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || board[i][j] == 'X') {
            return;
        }
        visited[i][j] = true;

        dfs(i+1, j, visited, board);
        dfs(i-1, j, visited, board);
        dfs(i, j+1, visited, board);
        dfs(i, j-1, visited, board);
    }
}