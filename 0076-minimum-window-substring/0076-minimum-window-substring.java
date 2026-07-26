class Solution {
    public String minWindow(String s, String t) {
        // Edge case
        if(t.length()>s.length()){
            return "";
        }
        
        // store all characters of t in map
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch=t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        int count=map.size();

        // start traverseing string s, and finding min window
        int left=0, right=0, start=0;
        int minLen=Integer.MAX_VALUE;
        int n=s.length();

        while(right<n){
            // Do calculation
            char ch=s.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1); //reduce freq of that el
 
                if(map.get(ch)==0){
                    count--;
                }
            }

        
            while(count==0){
                // find ans from calculation
                if(right-left+1 < minLen){
                    minLen=right-left+1;
                    start=left;
                }
                // Taki next window ko check krne ke lia characters ki freq mil jay jinse next window ke el comp honge
                char leftChar=s.charAt(left);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar)==0){
                        count++;
                    }
                    map.put(leftChar, map.get(leftChar)+1);

                }
                left++;
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start, start+minLen);
    }
}