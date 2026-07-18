class Solution {
    public boolean isThree(int n) {
        int count=0;
        // hm man ke chalnge num => 1 se and khud se divide hoga hi hoga
        // for exactly 3 => sirf count 1 chahiye , mltb ek aur assa num
        // jo n ko divide krta ho
        for(int i=2; i<n; i++){
            if(n%i==0){
                count++;
            }
        }
        if(count==1){
            return true;
        }

        return false;
    }
}