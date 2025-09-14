// Q1. Smallest Absent Positive Greater Than Average
// You are given an integer array nums.
// Return the smallest absent positive integer in nums such that it is strictly greater than the average of all elements in nums.
// The average of an array is defined as the sum of all its elements divided by the number of elements.

// Example 1:
// Input: nums = [3,5]
// Output: 6
// Explanation:
// The average of nums is (3 + 5) / 2 = 8 / 2 = 4.
// The smallest absent positive integer greater than 4 is 6.


// Example 3:
// Input: nums = [4,-1]
// Output: 2
// Explanation:
// The average of nums is (4 + (-1)) / 2 = 3 / 2 = 1.50.
// The smallest absent positive integer greater than 1.50 is 2.


// PATTERN ->

// APPROACH

// CODE
class Solution {
    public int smallestAbsent(int[] nums) {
        int sum=0;
        int n=nums.length;
        // Find Sum
        for(int i=0; i<n; i++){
            sum+=nums[i];
        }
        // Find Average
        double average = (double)sum/n;

        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        // STEP 3 -> Find Candidate Strictly greater than average
        // Positive Integer Strictly greater Than Average of nums
        // That is we need 
        // positive integer > Average
        // Math.floor(average) => Gives largest integer<= Average
        // average = 4.0 → floor(4.0) = 4 → candidate = 4 + 1 = 5

        int candidate = Math.max(1, (int)Math.floor(average)+1);

        // Step 4: Find Smallest Absent Candidate
        // increment candidate until we found absent One in Set
        while(set.contains(candidate)){
            candidate++;
        }
        return candidate;
    }
}


// TC -> O()
// SC -> O()