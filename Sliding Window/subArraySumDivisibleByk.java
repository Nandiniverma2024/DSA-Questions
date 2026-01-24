// 974. Subarray Sums Divisible by K
// Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
// A subarray is a contiguous part of an array.

// Example 1:
// Input: nums = [4,5,0,-2,-3,1], k = 5
// Output: 7
// Explanation: There are 7 subarrays with a sum divisible by k = 5:
// [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]



// Pattern Name: PrefixSum with modulo HashMap

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0, currSum=0;
        HashMap<Integer, Integer> map = new HashMap<>(); 
        // Base Case
        map.put(0,1);// remainder 0 already seen once
        for(int num : nums){
            // Calculating prefixSum in each step
            currSum+=num;
            int rem=currSum%k;

            if(rem<0){ // For handling negative remainder
                rem+=k;
            }
            // Why rem+k , since mathematically rem is always positive 
            // -2 % 5 = -2 , -2+5= 3(got positive remainder)
            if(map.containsKey(rem)){
                count+=map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem,0)+1);
        }
        return count;
    }
}




// Time Complexity (TC):
// O(n)
// Reason:
// Hum array ko sirf ek baar traverse kar rahe hain.
// Har step pe HashMap operations (get/put) average O(1) hote hain.



// Space Complexity (SC):
// O(k) (worst case)
// Reason:
// HashMap me hum remainders store kar rahe hain: 0 to k-1
// Maximum k different remainders ho sakte hain.
