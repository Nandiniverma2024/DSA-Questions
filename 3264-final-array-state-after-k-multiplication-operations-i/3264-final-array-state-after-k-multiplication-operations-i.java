class Solution {
    class Pair {
        int num;
        int idx;
        Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.num == b.num) {
                return a.idx - b.idx;
            }
            return a.num - b.num;
        });

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            pq.offer(new Pair(nums[i], i));
        }

        while (k > 0) {
            Pair curr = pq.poll();
            curr.num = curr.num * multiplier;
            nums[curr.idx] = curr.num;
            pq.offer(new Pair(curr.num, curr.idx));
            k--;
        }
        return nums;
    }
}