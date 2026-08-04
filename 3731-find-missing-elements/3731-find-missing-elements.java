class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;

        HashSet<Integer> set=new HashSet<>();
        List<Integer> li=new ArrayList<>();
        // Find Range
        int small=Integer.MAX_VALUE, large=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            small=Math.min(small, nums[i]);
            large=Math.max(large, nums[i]);
            set.add(nums[i]);
        }

        // Find number with in range
        for(int i=small; i<=large; i++){
            if(!set.contains(i)){
                li.add(i);
            }
        }

        return li;
    }
}