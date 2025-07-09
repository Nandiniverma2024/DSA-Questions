// 2149. Rearrange Array Elements by Sign

// You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

// You should return the array of nums such that the the array follows the given conditions:

// Every consecutive pair of integers have opposite signs.
// For all integers with the same sign, the order in which they were present in nums is preserved.
// The rearranged array begins with a positive integer.
// Return the modified array after rearranging the elements to satisfy the aforementioned conditions.


import java.util.*;

// BruteForce Approach
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(nums[i]<0){
                negList.add(nums[i]);
            }else{
                posList.add(nums[i]);
            }
        }
        int result[] = new int[n];
        int k=0;

        // Alterantely +ve and -ve els 
        for(int j=0; j<n/2; j++){
            result[k++]=posList.get(j);
            result[k++]=negList.get(j);
        }
        return result;
    }
}


// Time Complexity	O(n)
// Space Complexity	O(n)



// Optimal Appraoch
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int result[] = new int[n];
        int posIdx=0, negIdx=1;
        for(int num : nums){
            if(num>0){
                result[posIdx]=num;
                posIdx+=2;// Move to next even idx
            }else{
                result[negIdx]=num;
                negIdx+=2;// Move to next odd idx
            }
        }
        return result;
    }
}


// Time Complexity	O(n)
// Space Complexity	O(n)


