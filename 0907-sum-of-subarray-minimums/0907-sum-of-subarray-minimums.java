class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long sum=0;
        int mod=(int)1e9+7;
        int nsl[]=getNSL(arr);
        int nsr[]=getNSR(arr);
        for(int i=0; i<n; i++){
            long left=i-nsl[i];
            long right=nsr[i]-i;
            long contributer=(arr[i]*left*right)%mod;
            sum=(sum+contributer)%mod;
        }
        return (int)sum;
    }
    private int[] getNSL(int arr[]){
        int n=arr.length;
        int[] nsl = new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<n; i++){
            int curr=arr[i];
            while(!stack.isEmpty()&&arr[stack.peek()]>curr){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=stack.peek();
            }
            stack.push(i);
        }
        return nsl;
    }
    private int[] getNSR(int arr[]){
        int n=arr.length;
        int[] nsr = new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=n-1; i>=0; i--){
            int curr=arr[i];
            while(!stack.isEmpty()&&arr[stack.peek()]>=curr){
                stack.pop();
            }
            if(stack.isEmpty()){
                nsr[i]=n;
            }else{
                nsr[i]=stack.peek();
            }
            stack.push(i);
        }
        return nsr;
    }
}