class Solution {
    class Pair{
        int num;
        int idx;
        Pair(int num, int idx){
            this.num=num;
            this.idx=idx;
        }
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n=nums.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) ->{
                if(a.num==b.num){
                    return a.idx-b.idx;
                }
                return a.num-b.num;
            }
        );
        for(int i=0; i<n; i++){
            pq.offer(new Pair(nums[i], i));
        }
        while(k>0){
            Pair pair=pq.poll();
            int num=pair.num;
            int idx=pair.idx;

            num=num*multiplier;
            nums[idx]=num; //put value int array
            pq.offer(new Pair(num, idx));
            k--;
        }
        return nums;
    }
}