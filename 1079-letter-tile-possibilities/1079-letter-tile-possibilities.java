class Solution {
    public int numTilePossibilities(String tiles) {
        // StringBuilder sb=new StringBuilder();
        ArrayList<String> li=new ArrayList<>();
        HashSet<String> set=new HashSet<>();

        solve(tiles, "", li);
        for(int i=0; i<li.size(); i++){
            set.add(li.get(i));
        }
        return set.size()-1; //to remove empty string from starting
    }

    public void solve(String s, String ans, ArrayList<String> li){
        // s.length()==0 i.e hmne sare combination try kr lia
        if(s.length()==0){
            li.add(ans); //initially ans empty h
            return;
        }
        li.add(ans);
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            // s="abcde" // c wala choose kr lia , want to skip this in next iteration 
            // remove char at each level
            String newStr=s.substring(0,i) + s.substring(i+1, s.length());
            solve(newStr, ans+ch, li); 
            // ans+ch =>
            //add one char at each level ("a" at first level)
            //add next char at each level ("b" at first level)
            //add next char at each level ("c" at first level)
        }
    }
}