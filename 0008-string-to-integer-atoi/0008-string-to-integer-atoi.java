class Solution {
    public int myAtoi(String s) {
        // 1.Whitespaces
        s=s.trim();


        // Edge case(if string length become zero)
        if(s.length()<=0){
            return 0;
        }

        int i=0;
        // 2.Sign
        // Let num is postive
        int sign=1;

        if(s.charAt(i)=='+'){
            sign=1;
            i++;
        }else if(s.charAt(i)=='-'){
            sign=-1;
            i++;
        }

        long num=0;
        // 3.conversion
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            int ld=s.charAt(i)-'0'; //string ka character literal => integer literal
            num=num*10+ld; //also handle leading zeros

            // 4. rounding(round off)
            if(sign*num > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(sign*num < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return (int)(num*sign);
    }
}