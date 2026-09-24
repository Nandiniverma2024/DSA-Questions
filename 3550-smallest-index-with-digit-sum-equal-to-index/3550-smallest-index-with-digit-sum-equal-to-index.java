class Solution {
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        for(int i=0; i<nums.length; i++){
            int sum=0;
            int temp=nums[i];
            while(temp>0){
                int ld=temp%10;
                sum+=ld;
                temp/=10;
            }
            if(sum==i){
                return i;
            }
        }
        return -1;
    }
}