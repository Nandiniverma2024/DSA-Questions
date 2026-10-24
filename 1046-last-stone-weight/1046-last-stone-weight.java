class Solution {
    public int lastStoneWeight(int[] stones) {
        int ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)-> b-a);
        int n=stones.length;
        for(int i=0; i<n; i++){
            pq.offer(stones[i]);
        }

        while(pq.size()>=2){
            int first=pq.poll();
            int second=pq.poll();

            int diff=first-second;

            pq.offer(diff);
        }

        return pq.poll();
    }
}