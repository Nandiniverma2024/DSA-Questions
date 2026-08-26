class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        // List<String> li=new ArrayList<>();

        char board[][]=new char[n][n];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j]='.';
            }
        }

        solve(board, 0,  n, ans);

        return ans;
    }
    public void solve(char board[][], int row, int n, List<List<String>> ans){
        // Base Case
        if(row==n){
            List<String> li=new ArrayList<>();
            for(int i=0; i<n; i++){ //for row
                li.add(new String(board[i]));//convert character array into string
            }
            ans.add(new ArrayList<>(li));
        }
        for(int j=0; j<n; j++){
            if(isSafe(board, row, j, n)){
                board[row][j]='Q'; //Q batha di
                solve(board, row+1, n, ans); // call for next row
                board[row][j]='.'; //backtrack
            }
        }
    }
    public boolean isSafe(char board[][], int row, int col, int n){
        // Vertically up
        for(int i=row-1; i>=0; i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        // Left diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        // Right diagonal
        for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }
}