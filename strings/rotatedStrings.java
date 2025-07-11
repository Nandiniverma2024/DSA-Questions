// 796. Rotate String

// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

// A shift on s consists of moving the leftmost character of s to the rightmost position.

// For example, if s = "abcde", then it will be "bcdea" after one shift.
 


// BruteForce
class Solution {
    public boolean rotateString(String s, String goal) {
        // if length of both strings are not equal then 's' can never became 'gaol'
        if(s.length() != goal.length()){
            return false;
        }
        String rotated = s;
        // check 'goal' after each rotation
        for(int i=0; i<s.length(); i++){
            rotated = rotated.substring(1)+rotated.charAt(0);
            if(rotated.equals(goal)){
                return true;
            }
        }
        return false;
    }
}


// Dry run

// Dry Run for s = "abcde", goal = "cdeab"

// Initial:
// rotated = "abcde"
// goal = "cdeab"

// // i = 0
// rotated = rotated.substring(1) + rotated.charAt(0)
//          = "bcde" + "a"
//          = "bcdea"
// Compare: "bcdea".equals("cdeab") → false

// // i = 1
// rotated = rotated.substring(1) + rotated.charAt(0)
//          = "cdea" + "b"
//          = "cdeab"
// Compare: "cdeab".equals("cdeab") → true → return true


// Brute Force Time Complexity Breakdown:

// Let n = length of the string

// Outer loop runs 'n' times        -> O(n)

// Inside the loop (each iteration):
// - substring(1)                  -> O(n)
// - charAt(0)                     -> O(1)
// - concatenation with '+'       -> O(n)  (because new string is created)
// → Total for rotation part       -> O(2n)

// Also, equals() is called:
// - equals(goal)                 -> O(n)

// → Total work inside loop        -> O(2n + n) = O(3n) ≈ O(n)

// Since this happens 'n' times,
// Final Time Complexity            -> O(n) * O(n) = O(n²)
