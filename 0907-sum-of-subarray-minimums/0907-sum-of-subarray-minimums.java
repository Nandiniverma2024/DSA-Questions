class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int mod=1_000_000_007;
        long sum=0;
        int pse[]=getPSE(arr);
        int nse[]=getNSE(arr);

        // long contribution=0;
        for(int i=0; i<n; i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            long contribution=((long)left*right*arr[i])%mod;
            sum=(sum+contribution)%mod;
        }
        return (int)sum;
    }

    public int[] getPSE(int arr[]){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int pse[]=new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                pse[i]=-1;
            }else if(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                pse[i]=st.peek();
            }
            st.push(i);
        }
        return pse;
    }
    public int[] getNSE(int arr[]){
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int nse[]=new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }

            if(st.isEmpty()){
                nse[i]=n;
            }else if(!st.isEmpty() && arr[st.peek()]<arr[i]){
                nse[i]=st.peek();
            }
            st.push(i);
        }
        return nse;
    }
}