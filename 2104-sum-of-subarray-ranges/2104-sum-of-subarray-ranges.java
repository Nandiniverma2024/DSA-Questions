class Solution {
    public long subArrayRanges(int[] nums) {
        return (long)subArrayMax(nums)-subArrayMin(nums);
    }
    public long subArrayMin(int nums[]){
        int n=nums.length;
        int pse[]=getPSE(nums);
        int nse[]=getNSE(nums);
        long sum=0;
        // left => give subarray from left jinme curr el minimum h
        // right => give subarray from right jinme curr el minimum h
        for(int i=0; i<n; i++){
            int left=i-pse[i];
            int right=nse[i]-i;
            long contribution=1L*left*right*nums[i];
            sum=sum+contribution;
        }
        return sum;
    }
    public int[] getPSE(int nums[]){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int res[]=new int[n]; //it will store index

        for(int i=0; i<n; i++){
             // = nhi lagega kuki isme equal wale el nbi pop nhi ho rhe h
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public int[] getNSE(int nums[]){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int res[]=new int[n]; //it will store index

        for(int i=n-1; i>=0; i--){
            // = lagega kuki isme equal wale el nbi pop ho rhe h
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=n;
            }else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public long subArrayMax(int nums[]){
        int n=nums.length;
        int mod=1_000_000_007;
        int pge[]=getPGE(nums);
        int nge[]=getNGE(nums);
        long sum=0;
        // left => give subarray from left jinme curr el maximum h
        // right => give subarray from right jinme curr el maximum h
        for(int i=0; i<n; i++){
            int left=i-pge[i];
            int right=nge[i]-i;
            long contribution=1L*left*right*nums[i];
            sum=sum+contribution;
        }
        return sum;
    }
    public int[] getPGE(int nums[]){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int res[]=new int[n]; //it will store index

        for(int i=0; i<n; i++){
             // = nhi lagega kuki isme equal wale el nbi pop nhi ho rhe h
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=-1;
            }else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
    public int[] getNGE(int nums[]){
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int res[]=new int[n]; //it will store index

        for(int i=n-1; i>=0; i--){
            // = lagega kuki isme equal wale el nbi pop ho rhe h
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i]=n;
            }else{
                res[i]=st.peek();
            }
            st.push(i);
        }
        return res;
    }
}