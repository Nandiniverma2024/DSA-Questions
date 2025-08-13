// 326. Power of Three

// Given an integer n, return true if it is a power of three. Otherwise, return false.

// An integer n is a power of three, if there exists an integer x such that n == 3x.

 
// Approach
 class Solution {
    public boolean isPowerOfThree(int n) {
        // Base Case (Negative numbers and zero can never be a power of three)
        if(n==0 || n<0){
            return false;
        }
        while(n%3==0){
            n=n/3; //check for every step , if number id the power of three(that num should be divisible at every step )
        }
        return n == 1; // In the end if num==1 , that means that number is this whole number is pure power of three
    }
}

// DRY RUN
n = 27  
n > 0 → continue  
while (27 % 3 == 0) → true → n = 27 / 3 = 9  
while (9 % 3 == 0) → true → n = 9 / 3 = 3  
while (3 % 3 == 0) → true → n = 3 / 3 = 1  
while (1 % 3 == 0) → false → exit loop  
return (n == 1) → true ✅


// DRY RUN 2
n = 45  
n > 0 → continue  
while (45 % 3 == 0) → true → n = 45 / 3 = 15  
while (15 % 3 == 0) → true → n = 15 / 3 = 5  
while (5 % 3 == 0) → false → exit loop  
return (n == 1) → false ❌


// Time Complexity: O(log n) (since dividing n by 3 , in every step, aur divide karte-karte roughly log₃(n) steps lagenge.)
// Space Complexity: O(1)
