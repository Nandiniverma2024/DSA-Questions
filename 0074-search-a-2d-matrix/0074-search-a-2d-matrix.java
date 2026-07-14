class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0, high=n*m-1;
        while(low<=high){
            int mid1D=low+(high-low)/2;
            int row=mid1D/m, col=mid1D%m;
            int mid2D=matrix[row][col];

            if(mid2D==target){
                return true;
            }else if(mid2D<target){
                // search in right half
                low=mid1D+1;
            }else{
                high=mid1D-1;
            }
        }
        return false;
    }
}