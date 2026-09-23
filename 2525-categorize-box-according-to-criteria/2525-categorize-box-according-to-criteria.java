class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        // isse result int m cal na hoke long m cal hoga 
        // phele int m cal hoke long m store ho rha tha , ab long m store hoga pr res bi long m cal hoga
        long vol = 1L * width*length*height;
        boolean bulky=false;
        boolean heavy=false;

        // Bulky 
        if(length >= Math.pow(10,4) || width >= Math.pow(10,4) || height >= Math.pow(10,4) || vol >= Math.pow(10,9)){
            bulky=true;
        }

        // Heavy
        if(mass >= 100){
            heavy=true;
        }

        // both
        if(bulky && heavy){
            return "Both";
        }


        // bulky
        if(bulky && !heavy){
            return "Bulky";
        }


        // heavy
        if(heavy && !bulky){
            return "Heavy";
        }

        // Neither
        // if(!bulky && !heavy){
        //     return "Neither";
        // }

        return "Neither";
    }
}