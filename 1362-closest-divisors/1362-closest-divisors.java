class Solution {
    public int[] closestDivisors(int num) {
        int arr1[]=closest(num+1);
        int arr2[]=closest(num+2);

        int diff1=arr1[1]-arr1[0];
        int diff2=arr2[1]-arr2[0];

        if(diff1 < diff2){
            return arr1;
        }

        return arr2;
    }

    public int[] closest(int num){
        int ans[]=new int[2];
        for(int i=1; i*i<=num; i++){
            if(num%i == 0){
                ans[0]=i;
                ans[1]=num/i;
            }
        }
        return ans;
    }
}