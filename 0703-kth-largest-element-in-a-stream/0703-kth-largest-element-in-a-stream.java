class KthLargest {
    PriorityQueue<Integer> pq;
    // Here k and nums are the global data members of kthLargest class
    int k;
    int nums[];
    // This is constructor
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        this.k=k; // give kth largest el
        this.nums=nums;
        for(int num : nums){
            pq.offer(num);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */