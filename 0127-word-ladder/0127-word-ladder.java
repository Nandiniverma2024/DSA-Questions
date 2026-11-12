class Solution {
    class Pair{
        String s;
        int dis;
        Pair(String s, int dis){
            this.s=s;
            this.dis=dis;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>(wordList);

        if(!set.contains(endWord)){
            return 0;
        }

        Queue<Pair> q=new ArrayDeque<>();

        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord); // taki same word dobara queue mein na aaye

        while(!q.isEmpty()){
            Pair pair=q.poll();
            String word=pair.s;
            int dis=pair.dis;

            if(word.equals(endWord)){
                return dis;
            }

            for(int i=0; i<word.length(); i++){
                for(char ch='a'; ch<='z'; ch++){
                    // char array, isisliye bnaya kuki string immutable hoti h
                    // string m change nhi kr sakte 
                    char arr[]=word.toCharArray();
                    arr[i]=ch;

                    String newWord=new String(arr);

                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.offer(new Pair(newWord, dis+1));
                    }
                }
            }
        }
        return 0;
    }
}