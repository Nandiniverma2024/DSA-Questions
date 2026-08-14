class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        int left=0, right=0, n=s.length();
        int k=2, maxLen=Integer.MIN_VALUE;


        while(right<n){
            char ch=s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            if(map.get(ch)<=k){
                maxLen=Math.max(maxLen, right-left+1);
                right++;
            }else if(map.get(ch) > k){
                while(map.get(ch) > k){
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