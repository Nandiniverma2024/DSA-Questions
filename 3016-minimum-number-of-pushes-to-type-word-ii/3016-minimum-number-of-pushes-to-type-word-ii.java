class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map = new HashMap<>(); 
        int totalPush=0, uniqueCharCnt=0;

        for(int i=0; i<word.length(); i++){
            char ch=word.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        while(!map.isEmpty()){
            // Reset maxChar and maxFreq in each iteration
            char maxChar='\0';
            int maxFreq=-1;

            for(char ch:map.keySet()){
                int freq=map.get(ch);
                if(freq>maxFreq){
                    maxChar=ch;
                    maxFreq=freq;
                }
            }

            // Total 26 unique character
            if(uniqueCharCnt<8){
                totalPush+=maxFreq*1;
                uniqueCharCnt++;
            }else if(uniqueCharCnt>=8 && uniqueCharCnt<16){
                totalPush+=maxFreq*2;
                uniqueCharCnt++;
            }else if(uniqueCharCnt>=16 && uniqueCharCnt<24){
                totalPush+=maxFreq*3;
                uniqueCharCnt++;
            }else if(uniqueCharCnt>=24 && uniqueCharCnt<26){
                totalPush+=maxFreq*4;
                uniqueCharCnt++;
            }

            map.remove(maxChar);
        }
        return totalPush;
    }
}