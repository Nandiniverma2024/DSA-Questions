class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left=0, right=0;
        int n=s.length();
        int minLen=Integer.MAX_VALUE;
        int ones=0, start=0;
        HashSet<String> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        while(right<n){
            char ch=s.charAt(right);
            if(ch=='1'){
                ones++;
            }
            if(ones<k){
                right++;
            }else if(ones==k){
                while (s.charAt(left) == '0') {
                    left++;
                }
                int currLen=right-left+1;
                if(minLen>currLen){
                    minLen=currLen;
                    start=left;
                }else if(minLen==currLen){
                    String prev=s.substring(start, start+minLen);
                    String curr=s.substring(left, left+(right-left+1));
                    if(curr.compareTo(prev) < 0){ //compareTo => comp string with 0
                        start=left; //storage for next iterative comparision
                    }
                }   
                right++;
            }else if(ones>k){
                while(ones>k){
                    if(s.charAt(left) == '1') {
                        ones--;
                    }
                    left++;
                }

                // agr ones fir se k ke equal ho gye to
                while (s.charAt(left) == '0') {
                    left++;
                }
                int currLen=right-left+1;
                if(minLen>currLen){
                    minLen=currLen;
                    start=left;
                }else if(minLen==currLen){
                    String prev=s.substring(start, start+minLen);
                    String curr=s.substring(left, left+(right-left+1));
                    if(curr.compareTo(prev)<0){
                        start=left;
                    }
                }   
                right++;
            }
        }

        if(minLen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(start, minLen+start);
    }
}