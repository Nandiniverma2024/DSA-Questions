class Solution {
    public int maxLength(int[] nums) {
        int n=nums.length;
        int maxLen=0;
        for(int i=0; i<n; i++){
            int prod=1;
            int gcdVar=0, lcmVar=1;
            for(int j=i; j<n; j++){
                prod*=nums[j];
                gcdVar=gcd(gcdVar, nums[j]);
                lcmVar=lcm(lcmVar, nums[j]);

                if(prod==gcdVar*lcmVar){
                    maxLen=Math.max(maxLen, j-i+1);
                }
            }
        }
        return maxLen;
    }
    public int gcd(int a, int b){
        while(a>0 && b>0){
            if(a>b){
                a=a%b;
            }else{
                b=b%a;
            }
        }
        if(a==0){
            return b;
        }
        return a;
    }
    public int lcm(int a, int b){
        return a*b/gcd(a,b);
    }
}