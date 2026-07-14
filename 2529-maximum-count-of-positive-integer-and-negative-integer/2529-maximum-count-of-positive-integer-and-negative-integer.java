class Solution {
    public int maximumCount(int[] nums) {
        int n=nums.length;
        int posCnt=0, negCnt=0;
        int maxCount=0;
        for(int i=0; i<n; i++){
            if(nums[i]<0){
                negCnt++;
            }else if(nums[i]>0){
                posCnt++;
            }
        }
        maxCount=Math.max(posCnt, negCnt);

        return maxCount;
    }
}