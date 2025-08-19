// 342. Power of Four
// Given an integer n, return true if it is a power of four. Otherwise, return false.

// An integer n is a power of four, if there exists an integer x such that n == 4x.

// Approach
class Solution {
    public boolean isPowerOfFour(int n) {
        // Base Case
        if(n<=0){
            return false;
        }
        while(n%4==0){
            n/=4;
        }
        if(n!=1){ // If n is the power of 4 , it will reduce to 1
            return false;
        }
        return true;
    }
}

// Dry Run
n=16
n>0 -> continue;
while(16%4==0) -> true , n-> n/4 => 16/4 = 4;
while(4%4==0) -> true , n-> n/4 => 4/4 = 1;
while(1%4==0) -> false , exit loop;
Here, n reduce to 1(since it's the power of 4)
if(n!=1) -> return false nut here, n==1, => return true


// TC and SC
// consider is as Binary search
// Since in every iteration n becomes n/4(or quarter of original 4), means quaterly decrease ho rha h
TC => O(logn) (log base 4 n)
SC => O(1)
