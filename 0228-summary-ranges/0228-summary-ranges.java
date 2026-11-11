class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();

        int n=nums.length;
        int i=0;
        while(i<n){
            StringBuilder sb=new StringBuilder();
            int j=i;
            while(j+1<n && nums[j+1]==nums[j]+1){
                j++;
            }
            if(j==i){
                sb.append(nums[j]);
                ans.add(sb.toString());
            }else{
                sb.append(nums[i]+"->"+nums[j]);
                ans.add(sb.toString());
            }
            i=j+1;
        }
        return ans;
    }
}