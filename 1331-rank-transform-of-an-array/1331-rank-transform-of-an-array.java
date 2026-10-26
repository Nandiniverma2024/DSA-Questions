class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int newArr[]=new int[n];
        for(int i=0; i<n; i++){
            newArr[i]=arr[i];
        }

        Arrays.sort(arr);
        int rank=1;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<n; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i], rank);
                rank++;
            }
        }

        int res[]=new int[n];
        for(int i=0; i<n; i++){
            res[i]=map.get(newArr[i]);
        }
        return res;
    }
}