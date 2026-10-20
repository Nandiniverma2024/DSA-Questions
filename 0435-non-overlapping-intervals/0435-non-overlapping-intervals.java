class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int cnt=0;
        int n=intervals.length;
        int m=intervals[0].length;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int pst=intervals[0][0];
        int pft=intervals[0][1];
        for(int i=1; i<n; i++){
            int st=intervals[i][0];
            int ft=intervals[i][1];
            if(pft>st){
                cnt++;
            }else{
                pft=ft; // only update pft when pft is < st
            }
        }
        return cnt;
    }
}