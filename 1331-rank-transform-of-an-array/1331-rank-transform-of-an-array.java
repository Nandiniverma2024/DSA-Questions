class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int copy[]=arr.clone();
        Arrays.sort(copy);
        
        int rank=1;

        HashMap<Integer, Integer> map=new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(copy[i])){
                map.put(copy[i], rank);
                rank++;
            }
        }

        for(int i=0; i<n; i++){
            arr[i]=map.get(arr[i]);
        }
        
        return arr;
    }
}