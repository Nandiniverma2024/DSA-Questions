// 898. Bitwise ORs of Subarrays
// Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.

// The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. The bitwise OR of a subarray of one integer is that integer.

// A subarray is a contiguous non-empty sequence of elements within an array.

// Link -> https://leetcode.com/problems/bitwise-ors-of-subarrays/description/?envType=daily-question&envId=2025-07-31


// what we need to do -> Return number of uniques el.s from bitwiseOR of all subarrays

// Example:

// Input: arr = [1,1,2]
// Output: 3
// Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
// These yield the results 1, 1, 2, 1, 3, 3.(3 unique numbers from all values of bitwiseOR)
// There are 3 unique values, so the answer is 3.

// BruteForce Approach
// Find all subarrays -> calculate BitwiseOR of all subarrays -> 
// Add all BitwiseOR to hashSet(since store only unique el.s) -> return size of HashSet

import java.util.*;

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> StoreOR = new HashSet<>();
        int n=arr.length;
        // cal each subarray and thier ORs
        for(int i=0; i<n; i++){
            int correctOR=0;
            for(int j=i; j<n; j++){
                correctOR |= arr[j];
                // Add thier OR values to hashSet, which stores only unique values
                StoreOR.add(correctOR);
            }            
        }
        // we need to find unique el.s of bitwise OR, for this we can return size of HashSet(since, contains , only unique el.s)
        return StoreOR.size();
    }
}

// TC -> O(n^2) (cause of two nested loops)
// SC -> O(n^2) (in worst case all subaarays may have unique el.s (i.e  O(n^2) unique BitwiseOR values))

