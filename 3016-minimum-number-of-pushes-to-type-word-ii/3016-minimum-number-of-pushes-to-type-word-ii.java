class Solution {
    public int minimumPushes(String word) {
        int freq[]=new int[26];
        char wordArr[]=word.toCharArray();

        for(int i=0; i<word.length(); i++){
            char ch=wordArr[i];
            freq[ch-'a']++;
        }

        // This sort function sort array on basis of numerical values
        // smallest numerical values comes at starting positions 
        // and largest numerical values are go to last positions
        Arrays.sort(freq);

        int totalPush=0;
        int uniqueCharCnt=0;

        for(int i=25; i>=0; i--){
            if(freq[i]==0){
                break;
            }
            totalPush+=freq[i]*((uniqueCharCnt/8) + 1);
            uniqueCharCnt++;
        }

        return totalPush;
    }
}