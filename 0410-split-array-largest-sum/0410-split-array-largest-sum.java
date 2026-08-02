class Solution {
    public int splitArray(int[] nums, int k) {
        // same as book allocation problem
        int n=nums.length;
        // Edge case
        if(n<k){
            return -1;
        }

        // Define Range
        int max=Integer.MIN_VALUE, sum=0;
        for(int i=0; i<n; i++){
            max=Math.max(max, nums[i]);

            sum+=nums[i];
        }

        int start=max, end=sum;
        int ans=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            // mltb hr subArr ko minimum or equal mid val assign krni hi krni h        
            if(isPossible(nums, mid, k)){
                ans=mid; //possible sum
                end=mid-1; //possible sum se bi chota sum exist kr sakta h left half m
            } else{
                start=mid+1;
            }
        }
        return ans;
    }

    public boolean isPossible(int arr[], int possibleSum, int k){
        int subArr=1;
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(sum>possibleSum){
                subArr++;
                sum=arr[i];
            }

            // possible subArr > given subArr in ques, to return false
            if(subArr>k){
                return false;
            }
        }
        return true;
    }
}