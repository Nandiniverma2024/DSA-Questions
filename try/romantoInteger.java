import java.util.*;

// Optimal Approach
class Solution {
    public int romanToInt(String s) {
        int total = 0; // Final result
        int prev = 0;  // Value of previous Roman character (used to check subtraction rule)

        // Loop from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = getValue(s.charAt(i)); // Get the integer value of current Roman character

            // If current value is less than the previous one, subtract (e.g., IV = 5 - 1)
            if (curr < prev) {
                total -= curr;
            } else {
                // Otherwise, add it to the total
                total += curr;
            }

            // Update prev to current for the next iteration
            prev = curr;
        }

        return total; // Return the final converted integer
    }

    // return integer value of a Roman character
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0; // Default fallback, though input is always valid per problem
        }
    }
}


// Time Complexity: O(n)
// Space Complexity: O(1)


