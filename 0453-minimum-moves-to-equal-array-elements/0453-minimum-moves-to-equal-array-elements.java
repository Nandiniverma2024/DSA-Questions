class Solution {
    public int minMoves(int[] nums) {
        int moves=0;
        Arrays.sort(nums);
        int n=nums.length;


        int min=Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            min=Math.min(min, nums[i]);
        }
        // hr el m se smallest el minums kr dia
        for(int i=0; i<n; i++){
            moves+=nums[i]-min;
        }
        return moves;
    }
}