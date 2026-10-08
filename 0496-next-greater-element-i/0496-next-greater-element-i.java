class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        Stack<Integer> st=new Stack<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        int res[]=new int[n];

        // for next greater => run reverse loop
        for(int i=m-1; i>=0; i--){
            // while loop ensures stack will be a monotonic stack on each iteration(suru m sare chote el bad m sare bare el)
            while(!st.isEmpty() && st.peek()<nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                map.put(nums2[i], -1);
                st.push(nums2[i]);
            }else if(!st.isEmpty() && st.peek()>nums2[i]){
                map.put(nums2[i], st.peek());
                st.push(nums2[i]);
            }
        }

        for(int i=0; i<n; i++){
            res[i]=map.get(nums1[i]);
        }

        return res;
    }
}