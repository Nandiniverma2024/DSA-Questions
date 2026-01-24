// 930. Binary Subarrays With Sum
// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
// A subarray is a contiguous part of the array.

// Example 1:
// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are bolded and underlined below:
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]

// [PATTERN -> PREFIXSUM + HASHMAP]

public class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count=0, currSum=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        // Base Case
        // 0 sum sum already exist krta h before starting the array
        map.put(0,1);
        for(int num: nums){
            currSum+=num;
            int prefixSum=currSum-goal;
            if(map.containsKey(prefixSum)){
                count+=map.get(prefixSum);
            }
            map.put(currSum, map.getOrDefault(currSum,0)+1);
        }
        return count;
    }
} 



// For Base Case Explanation:
// hm 0 isiliye dal rhe h , agr kisi index pr pehli bar prefix sum = 0 aa jaye
// aur map me koi 0 na ho to hm count nahi badha paayenge

// Time Complexity (TC):
// O(n)

// Space Complexity (SC):
// O(n) (worst case)

// Reason:
// HashMap me hum prefix sums store kar rahe hain.
// Worst case me har prefix sum unique ho sakta hai → n entries in map.

