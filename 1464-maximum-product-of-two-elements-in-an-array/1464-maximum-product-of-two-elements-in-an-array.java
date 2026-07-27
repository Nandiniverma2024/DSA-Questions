class Solution {
    public int maxProduct(int[] nums) {
        int lar=Integer.MIN_VALUE, secLar=Integer.MIN_VALUE;
        int n=nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]>lar){
                secLar=lar;
                lar=nums[i];
            }else if(nums[i]>secLar){ //eg => 3,5,4
                secLar=nums[i];
            }
        }
        return (lar-1)*(secLar-1);
    }
}