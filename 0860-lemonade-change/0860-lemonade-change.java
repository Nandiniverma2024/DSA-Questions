class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0, ten=0;
    
        for(int i=0; i<bills.length; i++){
            if(bills[i]==5){
                five++;
            }else if(bills[i]==10){
                if(five>0){
                    five--;
                    ten++;
                }else{ // jb five==0 h
                    return false;
                }
            }else if(bills[i]==20){
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }else if(five>=3){ //5 ke tin dollar hone chahiye mera pass
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        
        return true; //sare customer ko change mil gya
    }
}