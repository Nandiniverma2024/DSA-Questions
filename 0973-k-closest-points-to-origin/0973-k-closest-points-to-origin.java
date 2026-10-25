class Solution {
    class Pair{
        int dist;
        int arr[];
        Pair(int dist, int arr[]){
            this.dist=dist;
            this.arr=arr;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> b.dist-a.dist);
        int n=points.length;
        for(int i=0; i<n; i++){
            pq.offer(new Pair(distance(points[i]), points[i]));

            if(pq.size()>k){
                pq.poll();
            }
        }

        int res[][]=new int[k][2];
        int j=0;
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int array[]=pair.arr;

            res[j]=array;
            j++;
        }
        return res;
    }


    public int distance(int arr[]){
        return (arr[0]*arr[0] + arr[1]*arr[1]);
    }
}