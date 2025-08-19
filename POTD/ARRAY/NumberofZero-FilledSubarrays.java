// 2348. Number of Zero-Filled Subarrays

// Given an integer array nums, return the number of subarrays filled with 0.

// A subarray is a contiguous non-empty sequence of elements within an array.

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0, maxCount=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                count++;
            }else{
                count=0;
            }
            maxCount+=count;
        }
        return maxCount;
    }
}

// TC -> O(n)
// Sc => O(1)