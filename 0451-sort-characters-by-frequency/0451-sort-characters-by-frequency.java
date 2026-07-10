class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1); 
        }
        
        StringBuilder sb=new StringBuilder();

        while(!map.isEmpty()){
            int maxFreq=0;
            char maxChar=' ';

            for(char ch:map.keySet()){
                int freq=map.get(ch);
                if(freq>maxFreq){
                    maxFreq=Math.max(maxFreq, freq);
                    maxChar=ch;
                }
            }
            for(int i=0; i<maxFreq; i++){
                sb.append(maxChar);
            }
            map.remove(maxChar);
        }

        return sb.toString();
    }
}