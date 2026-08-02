class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0, totalCost=0;
        // Gas kbi bi cost se km nhi honi chahiye
        for(int i=0; i<gas.length; i++){
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if(totalGas<totalCost){
            return -1;
        }
        
        int currentGas=0;
        int startIdx=0;


        // For tracking currentGas and startIdx
        for(int i=0; i<gas.length; i++){
            currentGas+=gas[i]-cost[i];
            if(currentGas<0){
                currentGas=0;
                startIdx=i+1;
            }
        }

        return startIdx;
    }
}