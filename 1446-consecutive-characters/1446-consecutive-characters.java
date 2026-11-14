class Solution {
    public int maxPower(String s) {
        char arr[]=s.toCharArray();
        int n=arr.length;
        int i=0;
        int maxLen=Integer.MIN_VALUE;
        while(i<n){
            int j=i;
            while(j+1<n && arr[j+1]==arr[j]){
                j++;
            }
            maxLen=Math.max(maxLen, j-i+1);
            i=j+1;
        }

        if(maxLen==Integer.MIN_VALUE){
            return 1;
        }

        return maxLen;
    }
}