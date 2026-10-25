class Solution {
    class Pair{
        int freq;
        String s;
        Pair(int freq, String s){
            this.freq=freq;
            this.s=s;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res=new ArrayList<>();
        int n=words.length;
        HashMap<String, Integer> map=new HashMap<>();
        PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->{
                if(a.freq!=b.freq){
                    return a.freq-b.freq;
                }
                return b.s.compareTo(a.s);
            });

        for(int i=0; i<n; i++){
            map.put(words[i], map.getOrDefault(words[i], 0)+1);
        }

        for(String key:map.keySet()){
            pq.offer(new Pair(map.get(key), key));
            if(pq.size()>k){
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            res.add(pair.s);
        }
        Collections.reverse(res);
        return res;
    }
}