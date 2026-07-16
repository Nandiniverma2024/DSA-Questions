class Solution {
    public void duplicateZeros(int[] arr) {
        int n=arr.length;
        int dup[]=new int[n];
        int i=0, j=0;
        while(i<n && j<n){
            if(arr[i]!=0){
                dup[j]=arr[i];
                i++;
                j++;
            }else{
                i++;
                j=j+2;
            }
        }

        for(int k=0; k<dup.length; k++){
            arr[k]=dup[k];
        }
     
    }
}