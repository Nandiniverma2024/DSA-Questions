class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        // Base case
        if(n%groupSize != 0){
            return false;
        }
        // Sort the array
        HashMap<Integer, Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0; i<n; i++){
            map.put(hand[i], map.getOrDefault(hand[i],0)+1);
            pq.offer(hand[i]);
        }
        
        while(!map.isEmpty()){
            // agr pq khali nhi h,or map m vo el nhi h , pop that el from heap(pq)
            while(!pq.isEmpty() && !map.containsKey(pq.peek())){
                pq.poll();
            }
            int first=pq.peek();

            for(int i=first; i<first+groupSize; i++){
                if(!map.containsKey(i)){ //agr next consecutive nhi mila to
                    return false;
                }
                map.put(i, map.get(i)-1);
                if(map.get(i) == 0){
                    map.remove(i);
                }
            }
        }
        return true;
    }
}