class Solution {
    public String reverseWords(String s) {

        // make stringBuilder of string (For Traversing)
        StringBuilder sb=new StringBuilder(s);

        // StringBuilder(For storing result)
        StringBuilder res=new StringBuilder();

        // Step1: Reverse whole string
        sb.reverse();

        // Step2: Reverse each word
        for(int i=0; i<sb.length(); i++){
            // char ch=sb.charAt(i);

            // (i) Check for the leading spaces , mid space and trailing spaces
            while(i<sb.length() && sb.charAt(i)==' '){
                i++;
            }

            // (ii) reverse and append word to stringBuilder(non-empty character)
            StringBuilder word=new StringBuilder();
            while(i<sb.length() && sb.charAt(i)!=' ' ){
                word.append(sb.charAt(i));
                i++;
            }


            // add in res(if some word exist)
            if(word.length()>0){
                res.append(word.reverse()); //word
                res.append(' ');  //space
            }
        }
        return res.toString().trim(); //last word ke bad ka space htane ke lia
    }
}