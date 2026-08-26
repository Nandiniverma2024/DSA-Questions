class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean visited[][]=new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                //idx => index to traverse on word
                if(solve(board, i, j, 0, visited, word)){
                    return true;
                }
            }
        }

        return false; 

        // return ans;
    }
    public boolean solve(char board[][], int i, int j, int idx, boolean visited[][], String word){
        int n=board.length;
        int m=board[0].length;
        // Base Condition
        if(idx==word.length()){
            return true;
        }
        // Invalid condition
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] || board[i][j]!=word.charAt(idx)){
            return false;
        }
        visited[i][j]=true;
        // find character then solve func explore other choices
        boolean found=  solve(board, i-1, j, idx+1, visited, word) || 
                        solve(board, i+1, j, idx+1, visited, word)||
                        solve(board, i, j-1, idx+1, visited, word)||
                        solve(board, i, j+1, idx+1, visited, word);
        visited[i][j]=false;

        return found;
    }
}