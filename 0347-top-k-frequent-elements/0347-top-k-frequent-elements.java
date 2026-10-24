class Solution {
    class Pair{
        int key;
        int value;
        Pair(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer, Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) -> a.key-b.key
        );

        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        for(int key:map.keySet()){
            pq.offer(new Pair(map.get(key), key));
            
            if(pq.size()>k){
                pq.poll();
            }
        }

        int res[]=new int[k];
        int i=0;
        while(!pq.isEmpty()){
           Pair pair=pq.poll();
           res[i]=pair.value; 
           i++;
        }

        return res;
    }
}