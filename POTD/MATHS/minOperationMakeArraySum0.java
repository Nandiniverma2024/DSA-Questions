3512. Minimum Operations to Make Array Sum Divisible by K
You are given an integer array nums and an integer k. You can perform the following operation any number of times:

Select an index i and replace nums[i] with nums[i] - 1.
Return the minimum number of operations required to make the sum of the array divisible by k.
 
Example 1:
Input: nums = [3,9,7], k = 5
Output: 4
Explanation:
Perform 4 operations on nums[1] = 9. Now, nums = [3, 5, 7].
The sum is 15, which is divisible by 5.

Example 2:
Input: nums = [4,1,3], k = 4
Output: 0
Explanation:
The sum is 8, which is already divisible by 4. Hence, no operations are needed.


CODE:
class Solution {
    public int minOperations(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        for(int i=0; i<n; i++){
            sum+=nums[i];
        }
        int rem=sum%k;
        if(rem==0){
            return 0;
        }else{
            return rem;
        }
    }
}

// we cna only peform operation sum-1, that means we need to reduce number till remainder time , so our operations will bi remainder value, so return remainder

// k = 5
// sum = 19
// 19 % 5 = 4

// 19 - 4 = 15 (divisible)



// Time Complexity: O(n)
// Space Complexity: O(1)
