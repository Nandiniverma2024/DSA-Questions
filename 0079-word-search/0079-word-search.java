class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;

        // mathch initial character of word
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]==word.charAt(0)){
                    if(solve(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    // solve fun => agr char mil gya , to ye word bi khud hi search kr dega
    public boolean solve(char board[][], String word, int i, int j , int idx){
        int n=board.length;
        int m=board[0].length;
        // Base Case
        if(idx==word.length()){ // idx will traverse on word
            return true;
        }
        // invalid positions
        if(i>=n || i<0 || j>=m || j<0 || board[i][j]!=word.charAt(idx)){
            return false;
        }
        char ch=board[i][j];
        board[i][j]='#'; //mark visited


        // find character and explore choice using idx
        boolean found=solve(board, word, i-1, j, idx + 1) || 
                      solve(board, word, i+1, j, idx + 1) ||
                      solve(board, word, i, j-1, idx + 1) ||
                      solve(board, word, i, j+1, idx + 1);
        
        // sari choice explore ho chuki h by using solve , uske bad board[i][j]=ch;, chlega
        board[i][j]=ch; //backtrack

        return found;
    }
}