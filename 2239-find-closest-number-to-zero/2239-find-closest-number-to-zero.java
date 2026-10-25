class Solution {
    class Pair{
        int dis;
        int num;
        Pair(int dis, int num){
            this.dis=dis;
            this.num=num;
        }
    }
    public int findClosestNumber(int[] nums) {
        int n=nums.length;
        int dis[]=new int[n];

        for(int i=0; i<n; i++){
            dis[i]=Math.abs(nums[i]);
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) -> {
                if(a.dis!=b.dis){
                    return a.dis-b.dis;
                }
                return b.num-a.num;
            });

        for(int i=0; i<n; i++){
            pq.offer(new Pair(dis[i], nums[i]));
        }

        return pq.poll().num;
    }
}