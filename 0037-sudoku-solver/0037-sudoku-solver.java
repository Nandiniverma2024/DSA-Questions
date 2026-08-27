class Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
    public boolean solve(char board[][], int row, int col){
        // Major Base Case for row
        if(row==9){
            return true;
        }

        // Base Case for col
        int nextRow=row, nextCol=col+1;
        if(nextCol==9){
            nextRow=row+1;
            nextCol=0;
        }

        if(board[row][col]!='.'){ //non-empty char(eg=> 3)
            return solve(board, nextRow, nextCol);
        }

        // digits ko unki shi jagah batao
        for(char dig='1'; dig<='9'; dig++){
            if(isSafe(board, row, col, dig)){
                board[row][col]=dig;
                if(solve(board, nextRow, nextCol)){
                    return true;
                }
                board[row][col]='.'; //backtrack
            }
        }

        return false;
    }
    public boolean isSafe(char board[][], int row, int col, char dig){
        int n=board.length;
        // Row
        for(int j=0; j<n; j++){
            if(board[row][j]==dig){
                return false;
            }
        }
        // Col
        for(int i=0; i<n; i++){
            if(board[i][col]==dig){
                return false;
            }
        }
        // Grid
        int sr=(row/3)*3; 
        int sc=(col/3)*3;

        for(int i=sr; i<=sr+2; i++){
            for(int j=sc; j<=sc+2; j++){
                if(board[i][j]==dig){
                    return false;
                }
            }
        }

        return true;
    }
}