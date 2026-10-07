class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int n=nums1.length;
        int m=nums2.length;

        for(int i=0; i<m-1; i++){
            int nextGreater=-1;
            for(int j=i+1; j<m; j++){
                if(nums2[j]>nums2[i]){
                    nextGreater=nums2[j];
                    break;
                }
            }
            map.put(nums2[i], nextGreater);
        }
        map.put(nums2[m-1], -1); //put -1 as value for the last el

        int res[]=new int[n];
        for(int i=0; i<n; i++){
            if(map.containsKey(nums1[i])){
                res[i]=map.get(nums1[i]);
            }
        }

        return res;
    }
}