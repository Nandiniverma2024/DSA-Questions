class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int largest = nums[n-1];

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += Math.abs(largest - nums[i]);
        }
        return ans;
    }
}