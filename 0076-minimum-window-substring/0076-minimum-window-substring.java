class Solution {
    public String minWindow(String s, String t) {
        // edge Case
        if(t.length()>s.length()){
            return "";
        }

        HashMap<Character, Integer> tMap=new HashMap<>();
        for(int i=0; i<t.length(); i++){
            char ch=t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch,0)+1);
        }
        
        int cnt=tMap.size();

        // sliding window on s
        int left=0, right=0, n=s.length();  
        int start=0, minLen=Integer.MAX_VALUE;

        while(right<n){
            char ch=s.charAt(right);
            if(tMap.containsKey(ch)){
                tMap.put(ch, tMap.get(ch)-1); //reduce freq
                if(tMap.get(ch)==0){
                    cnt--;
                }
            }

            while(cnt==0){
                if(minLen > right-left+1){
                    minLen=right-left+1;
                    start=left;
                }
                char leftCh=s.charAt(left);
                if(tMap.containsKey(leftCh)){
                    tMap.put(leftCh, tMap.get(leftCh)+1);
                    if(tMap.get(leftCh)>0){
                        cnt++;
                    }
                }
                left++; 
                
            }
            right++;
        } 

        // muje "s" string m "t" ke char mile hi nhi
        if(minLen==Integer.MAX_VALUE){
            return "";
        } 

        return s.substring(start, start+minLen);
    }
}