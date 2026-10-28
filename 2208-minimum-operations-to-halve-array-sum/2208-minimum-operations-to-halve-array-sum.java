class Solution {
    public int halveArray(int[] nums) {
        int cnt=0;
        double totalSum=0;
        int n=nums.length;

        PriorityQueue<Double> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<n; i++){
            totalSum+=nums[i];
            pq.offer((double)nums[i]);
        }

        double target=totalSum/2.0;
       
        //eg=> totalSum=33, halfsum=16.5, and total km hote hote 14.75 ho jayga, bs whi count return kr do

        while(totalSum>target){
            double largest=pq.poll();
            largest=largest/2;
            totalSum-=largest;
            pq.offer(largest);
            cnt++;
        }

        return cnt;  
    }
}