// Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

// You must write an algorithm that runs in O(n) time.



// BruteForce Approach

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums); // O(n log n)

        int longestStreak = 1;
        int currentStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            // Skip duplicates
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] == nums[i - 1] + 1) {
                currentStreak++;
            } else {
                longestStreak = Math.max(longestStreak, currentStreak);
                currentStreak = 1;
            }
        }

        return Math.max(longestStreak, currentStreak);
    }
}



// Time Complexity 	O(n log n) (due to sorting)
// Space Complexity	O(1) (if we don’t count sorting space)




// Optimal Approach

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        } 

        HashSet<Integer> set = new HashSet<>();
        // Insert el.s to set
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;

        // Iterate through each number in array to find longest consecutive sequence
        for (int it : nums) {
            // Check if it's the start of a sequence (i.e num-1 should not exist)
            // and also check if the num. is still in the set(to avoid duplicate)
            if (!set.contains(it - 1) && set.contains(it)) {
                int currentNum = it;// Start counting the sequence from num(curr.el.)
                int currentStreak = 0;

                // Count the length of the sequence (num+1, num+2, ...)
                while (set.contains(currentNum)) {
                    set.remove(currentNum);// remove no. to avoid counting it again
                    currentNum++;
                    currentStreak++;
                }

                // Update longest streak
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}


// 🕒 Time Complexity: O(n)
// 📦 Space Complexity: O(n)


