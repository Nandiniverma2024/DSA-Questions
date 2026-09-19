class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == dividend){
            return 1; //1 hi bar jayga to quotient = 1
        }

        boolean sign=true;

        // check for sign
        if(dividend <= 0 && divisor>0){
            sign=false;
        }else if(divisor<0 && dividend >= 0){
            sign=false;
        }

        long n=Math.abs((long) dividend);
        long d=Math.abs((long) divisor);

        long ans=0;

        while(n>=d){
            int cnt=0;
            while(n>= (d<< (cnt+1))){
                cnt++;
            }
            n -= d<<cnt;
            ans += 1L<<cnt;
        }

        if(ans>Integer.MAX_VALUE && sign==true){
            return Integer.MAX_VALUE;
        }
        if(ans>Integer.MAX_VALUE && sign==false){
            return Integer.MIN_VALUE;
        }

        if(sign==true){
            return (int)ans;
        }

        return (int)-ans;
    }
}