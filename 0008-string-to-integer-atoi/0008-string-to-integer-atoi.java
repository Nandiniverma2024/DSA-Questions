class Solution {
    public int myAtoi(String s) {
        int n=s.length();
        int total=0, sign=1, index=0;
        // 1. Check for leading spaces
        while(index<n && s.charAt(index)==' '){
            index++;
        }
        // 2. Check for signed integers
        if(index<n){
            if(s.charAt(index)=='+'){
                sign=1;//set sign to 1
                index++;
            }else if(s.charAt(index)=='-'){
                sign=-1;
                index++;
            }
        }
        // Convert String character digit into Integer charater digit
        while(index<n){
            char ch=s.charAt(index);
            if(ch<'0' || ch>'9'){
                break;
            }
            int digit=ch-'0';//convert character digit into integer digit
            // 4. check for overflow condition
            if(total>(Integer.MAX_VALUE-digit)/10){
                return sign==1?Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total=total*10+digit;
            index++;
        }
        return total*sign;
    }
}