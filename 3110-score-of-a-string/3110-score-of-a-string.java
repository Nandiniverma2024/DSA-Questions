class Solution {
    public int scoreOfString(String s) {
        int sum=0;
        for(int i=0; i<s.length()-1; i++){
            char ch1=s.charAt(i);
            char ch2=s.charAt(i+1);
            int num1=ch1-'a';
            int num2=ch2-'a';

            sum+=Math.abs(num2-num1);
        }
        return sum;
    }
}