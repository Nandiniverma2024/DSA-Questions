class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map=new HashMap<>();
        String word[]=s.split(" ");

        if(pattern.length()!=word.length){
            return false; //since we need one word for each character
        }

        for(int i=0; i<pattern.length(); i++){
            char ch=pattern.charAt(i);
            if(!map.containsKey(ch)){
                // agr pheli bar koi char aaya, or jo word uske sath map krna hagr vo phele se present h map m return false
                if(map.containsValue(word[i])){
                    return false;
                }
                map.put(ch, word[i]); //first time char aaya h, map it with word
            }else{ //agr char already map m h
                if(!map.get(ch).equals(word[i])){ //ch pr phel jo mapped word tha, agr vo current word ke equal nhi h to 
                    return false;
                }
            }
        }
        return true;
    }
}