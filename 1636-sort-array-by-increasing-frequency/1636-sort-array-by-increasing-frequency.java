class Solution {
    class Pair{
        int key, value;
        Pair(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    public int[] frequencySort(int[] nums) {
        int n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) -> {
                if(a.key!=b.key){
                    return a.key-b.key;
                }
                return b.value-a.value;
            });

        for(int key:map.keySet()){
            pq.offer(new Pair(map.get(key), key));
        }

        int res[]=new int[n];
        int i=0;
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int k=pair.key;
            int v=pair.value;

            for(int j=0; j<k; j++){
                res[i]=v;
                i++;
            }
        }

        return res;
    }
}