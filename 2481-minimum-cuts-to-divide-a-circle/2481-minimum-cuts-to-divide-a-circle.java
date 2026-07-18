class Solution {
    public int numberOfCuts(int n) {
        // Edge case
        if(n==1){
            return 0;
        }
        
        if(n%2==0){ //even
            return n/2;
        }

        // Odd
        return n;
    }
}