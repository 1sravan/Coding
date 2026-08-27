class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int window,minlen=Integer.MAX_VALUE;
        int[] prefixSum = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            prefixSum[i+1]=prefixSum[i]+nums[i];
        }
        Deque<Integer> minq =new ArrayDeque<>();
        for(int right=0;right<=nums.length;right++){
            while(!minq.isEmpty() && prefixSum[minq.peekLast()] >= prefixSum[right])
                minq.removeLast();
            minq.addLast(right);
            while(!minq.isEmpty() && prefixSum[right]-prefixSum[minq.peekFirst()] >= k){
                window=right-minq.peekFirst();
                minlen=Math.min(minlen,window);
                minq.removeFirst();
            }
        }
        return minlen==Integer.MAX_VALUE?-1:minlen;
    }
}
