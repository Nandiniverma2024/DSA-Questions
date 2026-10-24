import java.time.LocalDate;

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        // consider only non-leaf year
        // LocalDate aa=LocalDate.parse("2027-" + arriveAlice);
        // LocalDate al=LocalDate.parse("2027-" + leaveAlice);
        // LocalDate ba=LocalDate.parse("2027-" + arriveBob);
        // LocalDate bl=LocalDate.parse("2027-" + leaveBob);

        int a1=solve(arriveAlice);
        int a2=solve(leaveAlice);
        int b1=solve(arriveBob);
        int b2=solve(leaveBob);
        

        int start=Math.max(a1, b1);
        int end=Math.min(a2, b2);

        if(start>end){ // intervals overlap hi na krne ke
            return 0;
        }
        
        return end-start+1;
    }


    public int solve(String str){
        String arr[]=str.split("-");

        int month=Integer.parseInt(arr[0]);
        int day=Integer.parseInt(arr[1]);

        // ek month m kitne din h(add 0 , kuki 0th month nhi hota)
        int days[]={0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int i=1; //start from january
        int totalDays=0;
        // mothn is the current date month
        while(i<month){ //store dates till previous month
            totalDays+=days[i];
            i++;
        }
        // add date from current month
        totalDays+=day;

        return totalDays;
    }
}
