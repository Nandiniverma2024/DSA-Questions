class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int ans[]=new int[2];
        int n=mat.length;
        int m=mat[0].length;
        int maxCount=0, minRow=0;

        for(int i=0; i<n; i++){
            int count=0;
            for(int j=0; j<m; j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            if(maxCount<count){
                maxCount=count;
                minRow=i;
            }
        }
        
        ans[0]=minRow;
        ans[1]=maxCount;
       
        return ans;
    }
}