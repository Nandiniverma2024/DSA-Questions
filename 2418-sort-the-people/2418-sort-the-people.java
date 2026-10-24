class Solution {
    class Pair{
        int height;
        String name;
        Pair(int height, String name){
            this.height=height;
            this.name=name;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        int n=names.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.height-a.height);
        
        for(int i=0; i<n; i++){
            pq.offer(new Pair(heights[i], names[i]));
        }


        String res[]=new String[n];
        int i=0;
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int h=pair.height; // key
            String pn=pair.name; // value (pn => people Name)
            res[i]=pn;
            i++;
        }
        return res;
    }
}