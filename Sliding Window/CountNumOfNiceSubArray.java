// 1248. Count Number of Nice Subarrays
// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
// Return the number of nice sub-arrays.

// Example 1:
// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].


// Pattern Name: Prefix Sum + HashMap (Count Based Pattern)
// (ya specifically: Prefix Sum on Odd Count + HashMap)

// Code:

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count=0, oddCount=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // Base Case
        map.put(0,1);
        for(int num : nums){
            if(num%2!=0){
                oddCount++;
            }
            int prefixSum=oddCount-k;
            if(map.containsKey(prefixSum)){
                count+=map.get(prefixSum);
            }
            map.put(oddCount , map.getOrDefault(oddCount,0)+1);
        }
        return count;
    }
}




// Time Complexity (TC):
// O(n)

// Reason:
// Array ko sirf ek baar traverse kar rahe ho.
// Har step pe HashMap ke get / put operations average O(1) hote h.


// Space Complexity (SC):
// O(n) (worst case)

// Reason:
// HashMap me hum oddCount ke prefix values store kar rahe h.
// Worst case me har prefix oddCount unique ho sakta hai (0,1,2,3,...n).



