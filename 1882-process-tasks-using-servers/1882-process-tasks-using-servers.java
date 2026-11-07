class Solution {
    class freeServer{
        int weight;
        int idx;
        freeServer(int weight, int idx){
            this.weight=weight;
            this.idx=idx;
        }
    }
    class busyServer{
        long freeTime;
        int weight;
        int idx;
        busyServer(long freeTime, int weight, int idx){
            this.freeTime=freeTime;
            this.weight=weight;
            this.idx=idx;
        }
    }
    public int[] assignTasks(int[] servers, int[] tasks) {
    int n=servers.length;
    int m=tasks.length;
    // 1. Create free priority queue
    PriorityQueue<freeServer> freeq=new PriorityQueue<>(
        (a,b) -> {
            if(a.weight==b.weight){
                return a.idx-b.idx;
            }
            return a.weight-b.weight;
        }
    );

    // 2. Create busy priority queue
    PriorityQueue<busyServer> busyq=new PriorityQueue<>(
        (a,b) -> {
            if(a.freeTime!=b.freeTime){
                return Long.compare(a.freeTime, b.freeTime);
            }
            if(a.weight!=b.weight){
                return Integer.compare(a.weight, b.weight);
            }
            return Integer.compare(a.idx,b.idx);
        }
    );

    // 3. Add all servers to free PQ
    for(int i=0; i<servers.length; i++){
        freeq.offer(new freeServer(servers[i], i));
    }

    // 4. Create ans array
    int ans[]=new int[m];
    long time=0;

    // 5. Loop through all tasks
        for(int i=0; i<m; i++){
            time=Math.max(time, i);

        // Release servers whose freeTime <= current time
        while(!busyq.isEmpty() && busyq.peek().freeTime <= time){
            busyServer bs=busyq.poll();
            // int ft=bs.freeTime;
            int wt=bs.weight;
            int idx=bs.idx;

            freeq.offer(new freeServer(wt, idx));
        }
        // If free PQ is empty:
            if(freeq.isEmpty()){
                // Move time to earliest freeTime
                time=busyq.peek().freeTime;

                // Release all servers available at that time
                while(!busyq.isEmpty() && busyq.peek().freeTime <= time){
                    busyServer bs=busyq.poll();
                    // int ft=bs.freeTime;
                    int wt=bs.weight;
                    int idx=bs.idx;

                    freeq.offer(new freeServer(wt, idx));
                }
            }


        // Select best free server
        
            freeServer fs=freeq.poll();
            int wt=fs.weight;
            int idx=fs.idx;

        // Store its index in ans
            ans[i]=idx;
    
        // Add server to busy PQ
            busyq.offer(new busyServer((int)(time+tasks[i]), wt, idx));
        }
        return ans;
    }
}