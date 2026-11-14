class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum=Integer.MAX_VALUE;
        int n=nums.size();

        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=i; j<n; j++){
                sum+=nums.get(j);
                if(j-i+1>=l && j-i+1<=r){
                    if(sum>0){
                        minSum=Math.min(minSum, sum);
                    } 
                }
            }
        }

        if(minSum==Integer.MAX_VALUE){
            return -1;
        }

        return minSum;
    }
}