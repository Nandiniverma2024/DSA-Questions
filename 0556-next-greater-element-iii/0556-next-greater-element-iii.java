class Solution {
    public int nextGreaterElement(int n) {
        String str=String.valueOf(n);
        char arr[]=str.toCharArray();
        int m=arr.length;

        // 1.Find pivot
        int pivot=-1;
        for(int i=m-2; i>=0; i--){
            if(arr[i]<arr[i+1]){
                pivot=i;
                break;
            }
        }

        // circular permutations are not allowed
        // to agr pivot==-1 h ,mltb next permutation exist nhi krti
        if(pivot==-1){
            return -1;
        }

        // 2. Find first rightMost from end
        int rightMost=-1;
        for(int i=m-1; i>=0; i--){
            if(arr[i]-'0'>arr[pivot]-'0'){ //convert char literal to integer literal
                rightMost=i;
                break;
            }
        }

        // 3. swap
        swap(arr, pivot, rightMost);

        // 4. reverse
        reverse(arr, pivot+1, m-1);


        String st=new String(arr);
        long res=Long.parseLong(st);

        if(res>Integer.MAX_VALUE){ //toprevent from overflow condition
            return -1;
        }
        return (int)res;
    }
    public void swap(char arr[], int i, int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public void reverse(char arr[], int i, int j){
        while(i<j){
            char temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}