class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        // Edge case
        // if total flowers < num of flowers in bouquet
        if(((long)m*k)>n){
            return -1;
        }

        // Find range of flowers
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(bloomDay[i]>max){
                max=bloomDay[i];
            }
            if(bloomDay[i]<min){
                min=bloomDay[i];
            }
        }

        int start=min, end=max;
        int ans=0;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(bloomDay, mid, m, k)==true){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int arr[], int day, int m, int k){
        int cnt=0, bouquetCnt=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=day){
                cnt++; // count adjacent flowers
            }else{ //mltb m bare din pr aa gi hu
                bouquetCnt+=cnt/k;
                cnt=0; //so that we can find new group of adjacent flowwer for making another bouquet
            }
        }
        
        bouquetCnt+=cnt/k; //agr last m sirf chote ya km din m hi flower bloom kr rhe ho


        // agr bouquet count>= required bouquet
        if(bouquetCnt>=m){ 
            return true;
        }

        return false;
    }
}