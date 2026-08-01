class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;

        // Define Range
        int max=Integer.MIN_VALUE, sum=0;
        for(int i=0; i<n; i++){
            max=Math.max(max, weights[i]);
            sum+=weights[i];
        }
        int start=max, end=sum;
        int ans=-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            int reqDays=daysRequired(weights, mid);
            // mid=> capacity
            if(reqDays<=days){ //this can be my possible ans
                ans=mid;
                // search in left half
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }

    // Additional function => count days according to capacity
    public int daysRequired(int arr[], int capacity){
        int days=1, load=0;
        for(int i=0; i<arr.length; i++){
            load+=arr[i];
            if(load>capacity){
                days++;
                load=arr[i];
            }
        }
        return days;
    }
}