class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0, right=0;
        int n=s.length();
        int maxLen=0;
        HashMap<Character, Integer> map=new HashMap<>();
        while(right<n){
            // Calculations
            char ch=s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);
            // map.size() > window size (jo kbi hoga hi nhi)
            if(map.size()>right-left+1){
                right++;
            }else if(map.size()==right-left+1){
                // find ans from calculations(calculate maxLen)
                maxLen=Math.max(maxLen, right-left+1);
                right++;
            }else if(map.size()<right-left+1){ //map.size()<window size
                while(map.size()<right-left+1){
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