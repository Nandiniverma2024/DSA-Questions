class Solution {
    public int mySqrt(int x) {
        int start=1, end=x;
        int ans=0;
        // This is the case for floor value not for the exact value
        while(start<=end){ //largest valid val, smaller than x
            long mid=start+(end-start)/2;
            if((long)mid*mid <= x){
                ans=(int)mid;
                start=(int)mid+1;
            }else if((long)mid*mid > x){
                end=(int)mid-1;
            }
        }
        return ans;
    }
}