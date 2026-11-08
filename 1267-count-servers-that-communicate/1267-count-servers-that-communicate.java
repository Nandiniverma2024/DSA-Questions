class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int rowCnt[]=new int[n]; //cnt num of servers in each row
        int colCnt[]=new int[m]; //cnt num of servers in each col

        // Step1: cnt servers in each row and col
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){ //kisi bi cell m server h to increase its row and col cnt
                    rowCnt[i]++;
                    colCnt[j]++;
                }
            }
        }

        int cnt=0; //track communicating servers

        // Step2: check if server can communicate
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // grid[i][j]==1 -> curr cell pr server hona hi hona chahiye
                // uske same row m agr koi aur server h ya same col m koi aur server h to cnt ++
                if(grid[i][j]==1 && (rowCnt[i]>1 || colCnt[j]>1)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}