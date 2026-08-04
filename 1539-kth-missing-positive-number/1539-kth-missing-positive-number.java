class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int large=Integer.MIN_VALUE;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0; i<n; i++){
            large=Math.max(large, arr[i]);
            set.add(arr[i]);
        }

        
        int val=0, cnt=0;
        // Find number with in range
        for(int i=1; i<=large; i++){
            if(!set.contains(i)){
                val=i;
                cnt++;
                if(cnt==k){
                    return val;
                }
            }
        }
        return large + (k - cnt);
        // cnt => count tell kitne el gayab h start se
    }
}