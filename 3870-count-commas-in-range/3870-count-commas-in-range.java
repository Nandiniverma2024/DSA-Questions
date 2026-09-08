class Solution {
    public int countCommas(int n) {
       if(n>999 && n<=100000){
            return n-1000+1;
        }

        return 0;
    }
}