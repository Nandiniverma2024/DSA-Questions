class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String, Integer> map1=new HashMap<>();
        HashMap<String, Integer> map2=new HashMap<>();

        for(String str:words1){
            map1.put(str, map1.getOrDefault(str,0)+1);
        }
        for(String str:words2){
            map2.put(str, map2.getOrDefault(str,0)+1);
        }

        String smallArr[];

        if(words1.length<words2.length){
            smallArr=words1;
        }else{
            smallArr=words2;
        }

        int cnt=0;
        
        for(String str : smallArr){
            if(map1.getOrDefault(str,0)==1 && map2.getOrDefault(str,0)==1){
                cnt++;
            }
        }

        return cnt;
    }
}