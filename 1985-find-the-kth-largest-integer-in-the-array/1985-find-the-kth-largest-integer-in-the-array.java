class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<java.math.BigInteger> pq=new PriorityQueue<>();
        for(int i=0; i<nums.length; i++){
            pq.offer(new java.math.BigInteger(nums[i]));
            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.poll().toString();
    }
}