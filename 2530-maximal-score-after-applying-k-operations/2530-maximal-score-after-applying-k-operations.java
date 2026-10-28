class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int n=nums.length;
        for(int i=0; i<n; i++){
            pq.offer(nums[i]);
        }
        
        int largest=0;
        int newVal=0;
        long sum=0;
        while(k>0){
            largest=pq.poll();
            sum+=largest;
            newVal=(int)Math.ceil(largest/3.0);
            pq.offer(newVal);
            k--;
        }
        return sum;
    }
}