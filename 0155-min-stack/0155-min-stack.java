class MinStack {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    }
    Stack<Pair> st;
    public MinStack() {
        st=new Stack<>();
    }
    
    public void push(int value) {
        if(st.isEmpty()){
            st.push(new Pair(value, value));
        }else{
            int minVal=Math.min(value, st.peek().second);
            st.push(new Pair(value, minVal));
        }
    }
    
    public void pop() {
        if(!st.isEmpty()){
            st.pop();
        }
    }
    
    public int top() {
        return st.peek().first;
    }
    
    public int getMin() {
        return st.peek().second;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */