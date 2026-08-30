class Solution {
    public int minimumDeletions(int[] nums) {
        int smallest=Integer.MAX_VALUE;
        int largest=Integer.MIN_VALUE;
        int smalIdx=-1, largeIdx=-1;
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(smallest>nums[i]){
                smallest=nums[i];
                smalIdx=i;
            }
            if(largest<nums[i]){
                largest=nums[i];
                largeIdx=i;
            }
        }
        // find nearest and fartheset index
        int leftIdx=Math.min(smalIdx, largeIdx);
        int rightIdx=Math.max(smalIdx, largeIdx);
        
        int remFrnt=rightIdx+1;
        int remBack=n-leftIdx;
        int remFrntBack=(leftIdx+1) + (n-rightIdx);

        int cnt=Math.min(remFrnt, Math.min(remBack, remFrntBack));
        return cnt;
    }
}