class Solution {
    public List<String> letterCombinations(String digits) {
        // Base Case
        if(digits.length()==0){
            return new ArrayList<>();
        }
        String arr[]={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();

        // idx=0, for traversing on digits
        solve(digits, 0, sb, arr, ans);

        return ans;
    }
    public void solve(String digits, int idx, StringBuilder sb, String arr[], List<String> ans){
        // Base Case
        if(idx==digits.length()){
            ans.add(sb.toString());
            return;
        }

        char ch=digits.charAt(idx); // '2'
        int result = Character.getNumericValue(ch); // convert '2' => 2


        String temp=arr[result];  //arr[2] => "abc"

        // Traversing on string "abc"
        for(int i=0; i<temp.length(); i++){
            sb.append(temp.charAt(i)); //"a"
            solve(digits, idx+1, sb, arr, ans); // idx+1 => 3 => "def"
            sb.deleteCharAt(sb.length()-1);
            // ake sath d aane ke bad , d removeb  ho jayga (by deleteCharAt)
        }
    }
}