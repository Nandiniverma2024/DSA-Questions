class MedianFinder {
    PriorityQueue<Integer> left; //left_Max_pq
    PriorityQueue<Integer> right; //right_Min_pq

    public MedianFinder() {
        left=new PriorityQueue<>(Collections.reverseOrder());
        right=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step1: insert el
        // since left ka peek left m present sare el se bara h
        if(left.isEmpty() || num<=left.peek()){
            left.offer(num);
        }else{
            right.offer(num);
        }

        // Step2: check for size 
        if(left.size()>right.size()+1){ // left, right 
            right.offer(left.poll());
        }
        if(right.size()>left.size()){ // left, right 
            left.offer(right.poll());
        }

    }
    
    public double findMedian() {
        // if have odd el
        if(left.size()>right.size()){
            return left.peek();
        }

        // i.e having even el
        return (double)(left.peek()+right.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */