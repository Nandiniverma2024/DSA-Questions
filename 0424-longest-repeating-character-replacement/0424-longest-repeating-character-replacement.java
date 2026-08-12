// Task => puri window se kitne char change krne h
// filps => Total len-maxFreq

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map=new HashMap<>();
        int left=0, right=0, n=s.length();
        int len=0, maxLen=0;
        int maxFreq=0;

        while(right<n){
            char ch=s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq, map.get(ch));

            // int totalLen=right-left+1;
            // int flips=totalLen-maxFreq;

            if((right-left+1)-maxFreq <= k){
                len=right-left+1;
                maxLen=Math.max(len, maxLen);
                right++;
            }else if((right-left+1)-maxFreq > k){
                while((right-left+1)-maxFreq > k){
                    map.put(s.charAt(left), map.get(s.charAt(left))-1);
                    if(map.get(s.charAt(left))==0){
                        map.remove(s.charAt(left));
                    }
                    left++;
                }
                right++;
            }
        }
        return maxLen;
    }
}


