class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> li=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        // Generate all sequential number within range
        // consider every digit is starting digit(from 1 to 9)
        for(int i=1; i<=9; i++){

            int num=i; //start making number from strating digit

            for(int j=i+1; j<=9; j++){ //add next sequential digits

                num=num*10+j; //apend next digit

                // check condition(if num is in range or not)
                if(num>=low && num<=high){

                    li.add(num);

                }

            }

        }
        Collections.sort(li);
        return li;
    }
}

// last digit and first digit have same concept
// num=num*10+j;  ==> ek m existing num ke aage digit jor rhe h 
// rev=rev*10+ld; ==> dusre m reverse number bna rhe h