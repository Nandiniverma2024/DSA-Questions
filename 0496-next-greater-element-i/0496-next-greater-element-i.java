class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int res[]=new int[n];
        HashMap<Integer, Integer> map=new HashMap<>();

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
        // put last wali value
        map.put(nums2[m-1], -1);

        for(int i=0; i<n; i++){
            res[i]=map.get(nums1[i]);
        }

        return res;
    }
}

// for loop appraoch