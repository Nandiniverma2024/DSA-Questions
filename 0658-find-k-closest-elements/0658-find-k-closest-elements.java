class Solution {
    class Pair{
        int dist;
        int num;
        Pair(int dist, int num){
            this.dist=dist;
            this.num=num;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b) -> {
                if(a.dist!=b.dist){
                    return b.dist-a.dist;
                }
                return b.num-a.num;
            }
        );

        for(int i=0; i<n; i++){
            pq.offer(new Pair(distance(arr[i], x), arr[i]));

            if(pq.size()>k){
                pq.poll();
            }
        }

        ArrayList<Integer> res=new ArrayList<>();
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            res.add(pair.num);
        }

        Collections.sort(res);

        return res;
    }

    public int distance(int y, int x){
        return Math.abs(y-x);
    }
}