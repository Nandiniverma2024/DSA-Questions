class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        
        int res[][]=new int[n+1][2];
        int i=0;
        int idx=0; //for traversing on res array

        // Step1: check for left
        while(i<n && intervals[i][1]<newInterval[0]){
            res[idx]=intervals[i];
            i++;
            idx++;
        }
        // Step2: check for the overlapping intervals (middle part)
        while(i<n && intervals[i][0]<=newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0], newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res[idx]=newInterval;
        idx++;

        // step3: check for the remaining right part
        while(i<n){
            res[idx]=intervals[i];
            i++;
            idx++;
        }

        return Arrays.copyOf(res, idx); //remove extra rows from res
    }
}