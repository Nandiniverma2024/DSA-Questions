class Solution {
    public int minEatingSpeed(int[] piles, int h) { 
        Arrays.sort(piles);
        int n=piles.length;
        int start=1, end=piles[n-1];
        int ans=0;
        // Find exact hour i.e k with binary search
        // img array => 1 to 11
        while(start<=end){
            int mid=start+(end-start)/2;
            int hours=ganteGinfun(piles,mid);
            if(hours<=h){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public int ganteGinfun(int arr[], int k){
        int n=arr.length;
        int count=0;
        for(int i=0; i<n; i++){
            count += Math.ceil((double)arr[i] / k);
        }
        return count;
    }
}