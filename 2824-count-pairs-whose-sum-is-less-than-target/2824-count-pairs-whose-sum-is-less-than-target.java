class Solution {
    public int countPairs(List<Integer> nums, int target) {
        int n=nums.size();
        int left=0, right=n-1;
        int cnt=0;
        Collections.sort(nums);

        while(left<right){
            if((nums.get(left) + nums.get(right)) < target){
                // agr list sorted h, right-left => krne pr sare bich ke el ke pair ka sum bi target se less hoga
                cnt+=right-left;
                left++;
            }else{
                right--;
            }
        }
        return cnt;
    }
}