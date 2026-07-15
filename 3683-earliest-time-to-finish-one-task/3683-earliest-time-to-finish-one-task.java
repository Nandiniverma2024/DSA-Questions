class Solution {
    public int earliestTime(int[][] tasks) {
        int minSum=Integer.MAX_VALUE;
        int n=tasks.length;
        int m=tasks[0].length;
        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=0; j<m; j++){
                sum+=tasks[i][j];
            }
            minSum=Math.min(minSum, sum);
        }
        return minSum;
    }
}