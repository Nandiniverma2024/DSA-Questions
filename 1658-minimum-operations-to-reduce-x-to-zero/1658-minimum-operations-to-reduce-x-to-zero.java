class Solution {
    public int minOperations(int[] nums, int x) {
        int left=0, right=0, n=nums.length;
        int totalSum=0;
        for(int i=0; i<nums.length; i++){
            totalSum+=nums[i];
        }
        // TotalSum-x
        int target=totalSum-x;
        if(target<0){
            return -1;
        }else if(target==0){
            return n;
        }
        int sum=0;
        int maxLen=Integer.MIN_VALUE;

        while(right<n){
            sum+=nums[right];
            if(sum<target){
                right++;
            }else if(sum==target){
                maxLen=Math.max(maxLen, right-left+1);
                right++;
            }else if(sum>target){
                while(sum>target){
                    sum-=nums[left];
                    left++;
                }
                if(sum==target){
                    maxLen=Math.max(maxLen, right-left+1);
                }
                right++;
            }
        }

        if(maxLen==Integer.MIN_VALUE){
            return -1;
        }

        return n-maxLen;
    }
}