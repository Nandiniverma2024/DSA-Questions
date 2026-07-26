class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        int lar=Integer.MIN_VALUE, secLar=Integer.MIN_VALUE, thdLar=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;
        int maxProd=1;
        for(int i=0; i<n; i++){
            // For maximum value
            if(nums[i]>=lar){
                thdLar=secLar;
                secLar=lar;
                lar=nums[i];
            }else if(nums[i]>=secLar){
                thdLar=secLar;
                secLar=nums[i];
            }else if(nums[i]>=thdLar){
                thdLar=nums[i];
            }
            
            // For minimum value
            if(nums[i]<min1){
                min2=min1;
                min1=nums[i];
            }else if(nums[i]<min2){
                min2=nums[i];
            }
        }
        
        return Math.max(min1*min2*lar,lar*secLar*thdLar);
    }
}