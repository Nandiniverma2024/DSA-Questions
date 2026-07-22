class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        int start=0, end=n-1;
        // Rarest edge case
        if(n==1){
            return 0;
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            // compare m mid-1 and mid+1 h , take it as prev and next
            int prev=(mid-1==-1)?Integer.MIN_VALUE:nums[mid-1];//take -infity if idx=-1, else take mid-1 wala el
            int next=(mid+1==n)?Integer.MIN_VALUE:nums[mid+1]; //take -infity if idx=n, else take mid+1 wala el
            if(nums[mid]>prev && nums[mid]>next){
                return mid;
            }else if(nums[mid]<next){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}