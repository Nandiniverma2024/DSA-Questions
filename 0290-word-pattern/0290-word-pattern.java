class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map1 = new HashMap<>();
        HashMap<String, Character> map2 = new HashMap<>();

        String[] words = s.split(" ");

        if(pattern.length() != words.length) {
            return false;
        }

        for(int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);

            if(map1.containsKey(ch) && !map1.get(ch).equals(words[i])) {
                return false;
            }

            if(map2.containsKey(words[i]) && map2.get(words[i]) != ch) {
                return false;
            }

            map1.put(ch, words[i]);
            map2.put(words[i], ch);
        }
        return true;
    }
}