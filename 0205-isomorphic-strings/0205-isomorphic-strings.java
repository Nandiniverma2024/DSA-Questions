class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Map => (sCharacter, tCharacter)
        HashMap<Character, Character> sTot=new HashMap<>();
        // Map => (tCharacter, sCharacter)
        HashMap<Character, Character> tTos=new HashMap<>();

        // Check for sTot relation
        for(int i=0; i<s.length(); i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);

            // check one-one relation from s to T
            if(sTot.containsKey(ch1)){
                if(sTot.get(ch1)!=ch2){
                    return false;
                }
            }else{
                sTot.put(ch1, ch2);
            }


            // Again, check one-one relation from t to S
            if(tTos.containsKey(ch2)){
                if(tTos.get(ch2)!=ch1){
                    return false;
                }
            }else{
                tTos.put(ch2, ch1);
            }
        }

        
        return true;
    }
}