class Solution {
    public int findMin(int[] nums) {
        int n=nums.length;
        int left=0, right=n-1;
        while(left<=right){
            // if whole array is sorted then return 0th el
            if(nums[left]<=nums[right]){
                return nums[left];
            }

            int mid=left+(right-left)/2; //let mid is the curr el

            int prev=(mid-1+n)%n; //to get correct index in circular array
            int next=(mid+1)%n;

            if(nums[mid]<=nums[prev] && nums[mid]<=nums[next]){
                return nums[mid];
            }else if(nums[left]<=nums[mid]){ // if left part is sorted
                left=mid+1; //search in unsorted right part
            }else{ // if right part is sorted
                right=mid-1; // search in unsorted left part
            }
        }
        return -1;
    }
}