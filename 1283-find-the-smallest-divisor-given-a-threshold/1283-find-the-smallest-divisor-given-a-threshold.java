class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        // Define Range(1 to max El.)
        int max=Integer.MIN_VALUE, sum=0;
        for(int i=0; i<n; i++){
            max=Math.max(max, nums[i]);
        }

        int start=1, end=max;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            // mid => possible divisor int range of divisors
            int sumDiv=divisorSum(nums, mid);
            if(sumDiv<=threshold){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public int divisorSum(int arr[], int divisor){
        int sum=0;
        for(int i=0; i<arr.length; i++){
            sum+=(int)Math.ceil((double)arr[i]/divisor);
        }
        return sum;
    }
}

//  Here, mid is my divisor