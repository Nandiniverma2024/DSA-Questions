class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;  // total sum
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // findout subarray of maxLength in middle having sum == target
        // to answer hoga ---> nums.length - maxLenght(required minimum length/operations)
        int target = sum - x;

        // edge cases
        if(target < 0) {
            return -1;
        }

        if(target == 0) {
            return nums.length;
        }

        int left = 0, right = 0;
        int s = 0, maxLen = 0;
        while(right < nums.length) {
            s += nums[right];
            if(s < target) {
                right++;
            } else if(s == target) {
                maxLen = Math.max(maxLen, right-left+1);
                right++;
            } else if(s > target) {
                while(s > target) {
                    s -= nums[left];
                    left++;
                }
                if(s == target) {
                    maxLen = Math.max(maxLen, right-left+1);
                }
                right++;
            }
        }

        return maxLen == 0 ? -1 : nums.length - maxLen;
    }
}