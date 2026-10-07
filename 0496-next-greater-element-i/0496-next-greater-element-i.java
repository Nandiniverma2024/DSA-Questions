class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        HashMap<Integer, Integer> map=new HashMap<>();

        int n=nums1.length;
        int m=nums2.length;
        int res[]=new int[n];

        for(int i=m-1; i>=0; i--){
            if(st.isEmpty()){
                map.put(nums2[i], -1);
                st.push(nums2[i]);
            }else if(!st.isEmpty() && st.peek()>nums2[i]){
                map.put(nums2[i], st.peek());
                st.push(nums2[i]);
            }else if(!st.isEmpty()){
                while(!st.isEmpty() && st.peek()<nums2[i]){
                    st.pop();
                }

                if(!st.isEmpty() && st.peek()>nums2[i]){
                    map.put(nums2[i], st.peek());
                    st.push(nums2[i]);
                }else if(st.isEmpty()){
                    map.put(nums2[i], -1);
                    st.push(nums2[i]);
                }
            }
        }
        

        for(int i=0; i<n; i++){
            if(map.containsKey(nums1[i])){
                res[i]=map.get(nums1[i]);
            }
        }

        return res;
    }
}