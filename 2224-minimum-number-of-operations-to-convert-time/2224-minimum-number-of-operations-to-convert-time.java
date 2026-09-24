class Solution {
    public int convertTime(String current, String correct) {
        String arr1[]=current.split(":");
        String arr2[]=correct.split(":");

        int hr1=Integer.parseInt(arr1[0])*60;
        int hr2=Integer.parseInt(arr2[0])*60;

        int min1=Integer.parseInt(arr1[1]);
        int min2=Integer.parseInt(arr2[1]);

        int sum1=hr1+min1;
        int sum2=hr2+min2;
        int cnt=0;

        while(sum1<sum2){
            int diff=sum2-sum1;
            if(diff>=60){
                sum1+=60;
                cnt++;
            }else if(diff>=15){
                sum1+=15;
                cnt++;
            }else if(diff>=5){
                sum1+=5;
                cnt++;
            }else if(diff>=1){
                sum1+=1;
                cnt++;
            }
        }
        return cnt;
    }
}