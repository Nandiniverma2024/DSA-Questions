class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int l=0, r=n-1;
        int lMax=0, rMax=0;
        int ans=0;
        while(l<r){
            lMax=Math.max(lMax, height[l]);
            rMax=Math.max(rMax, height[r]);

            // Left
            if(lMax<=rMax){
                ans+=Math.abs(lMax-height[l]);
                l++;
            }else if(rMax<lMax){ // Right
                ans+=Math.abs(rMax-height[r]);
                r--;
            }
        }
        return ans;
    }
}