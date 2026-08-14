class Solution {
    public int numberOfSubstrings(String s) {
        int left=0, right=0, n=s.length();
        int k=3, cnt=0;

        HashMap<Character, Integer> map=new HashMap<>();

        while(right<n){
            char ch=s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);

            while(map.size()==k){
                cnt += n-right;

                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            // agr map ka size k ke barabar nhi h, to right++ krke k ke barabar kro
            right++;
        }
        return cnt;
    }
}