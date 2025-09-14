// Q1. Earliest Time to Finish One Task

// You are given a 2D integer array tasks where tasks[i] = [si, ti].
// Each [si, ti] in tasks represents a task with start time si that takes ti units of time to finish.
// Return the earliest time at which at least one task is finished.

 

// Example 1:
// Input: tasks = [[1,6],[2,3]]
// Output: 5
// Explanation:
// The first task starts at time t = 1 and finishes at time 1 + 6 = 7. The second task finishes at time 2 + 3 = 5. You can finish one task at time 5.


// PATTERN -> GREEDY(since finding finish time at each task)


// Approach -> Find Finish Time


// CODE
class Solution {
    public int earliestTime(int[][] tasks) {
        int minTime=Integer.MAX_VALUE;
        for(int i=0; i<tasks.length; i++){
            // Start Time -> tasks[i][0]
            // End Time -> tasks[i][1]
            int finishTime=tasks[i][0]+tasks[i][1];
            minTime=Math.min(minTime,finishTime);
        }
        return minTime;
    }
}




// TC -> O(N)
// SC -> O(1)