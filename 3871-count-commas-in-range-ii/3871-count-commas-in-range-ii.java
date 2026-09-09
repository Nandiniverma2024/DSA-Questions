class Solution {
    public long countCommas(long n) {
        long ans=0;
        long start=1000;
        while(start<=n){
            ans+=n-start+1;
            start*=1000;
        }
        return ans;
    }
}

// Total numbers from 1000 to 5000 is 4001, hr num m ek comma to total num is 4001
// 5000 - 1000 + 1 
// = 4001

// 1000       → 1 comma
// 1000 000    → 2 commas
// 1000 000 000 → 3 commas