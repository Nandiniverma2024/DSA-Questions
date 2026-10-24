import java.time.LocalDate;

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        LocalDate aa=LocalDate.parse("2027-" + arriveAlice);
        LocalDate al=LocalDate.parse("2027-" + leaveAlice);
        LocalDate ba=LocalDate.parse("2027-" + arriveBob);
        LocalDate bl=LocalDate.parse("2027-" + leaveBob);

        int a1=aa.getDayOfYear();
        int a2=al.getDayOfYear();
        int b1=ba.getDayOfYear();
        int b2=bl.getDayOfYear();

        int start=Math.max(a1, b1);
        int end=Math.min(a2, b2);

        if(start>end){ // intervals overlap hi na krne ke
            return 0;
        }
        
        return end-start+1;
    }
}
