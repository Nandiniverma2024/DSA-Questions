class Solution {
    public boolean stoneGame(int[] piles) {
        int alice=0, bob=0;
        int evenGpSum=0, oddGpSum=0;
        int n=piles.length;
        for(int i=0; i<n; i++){
            if(i%2==0){
                evenGpSum+=piles[i];
            }else{
                oddGpSum+=piles[i];
            }
        }
        if(evenGpSum>oddGpSum){
            alice=evenGpSum;
            bob=oddGpSum;
        }else if(oddGpSum>evenGpSum){
            alice=oddGpSum;
            bob=evenGpSum;
        }

        if(alice>bob){
            return true;
        }

        return false;
    }
}