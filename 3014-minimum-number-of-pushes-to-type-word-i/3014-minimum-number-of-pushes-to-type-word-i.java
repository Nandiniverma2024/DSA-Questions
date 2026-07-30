class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int group=n/8;
        int rem=n%8;
        int sum=0;

        for(int i=1; i<=group; i++){
            sum+=8*i; //since we have 8 keys
        }

        return sum+rem*(group+1);
    }
}

// 26 char , 8 keys
// n/8 => iterations
// 8x1
// 8x2
// 8x3

// n%8 => remaning char
// 8*next group => 26%8 =>2
// rem*next_group