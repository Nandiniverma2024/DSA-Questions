import java.util.*;

// 31. Next Permutation

// A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

// For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
// The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

// For example, the next permutation of arr = [1,2,3] is [1,3,2].
// Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
// While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
// Given an array of integers nums, find the next permutation of nums.

// The replacement must be in place and use only constant extra memory.

// BruteForce

// Generate all permutations
// Sort them and return the one after current
//  ❌ Very inefficient for large arrays

//  ⌛ TC: O(n! × n)
//  📦 SC: O(n)


// Optimal Approach
class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length, index=-1;
        // 1. Find Break Point
        for(int i=n-2; i>=0; i--){
            if(nums[i+1]>nums[i]){
                index=i;
                break;
            }
        }
        // Edge case(when we are on last one,no decreasing el. is found)
        if(index==-1){
           reverse(nums,0,n-1);
           return;
        }
        // 2. Find next grater el. than swap it with nums[i]
        for(int i=n-1; i>index; i--){
            if(nums[i]>nums[index]){
                int temp=nums[i];
                nums[i]=nums[index];
                nums[index]=temp;
                break;
            }
        }
        // 3. Reverse Right Half
        reverse(nums, index+1, n-1);
    }
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


// ⌛ Time complexity : O(n)

// 📦 Space complexity : O(1)

