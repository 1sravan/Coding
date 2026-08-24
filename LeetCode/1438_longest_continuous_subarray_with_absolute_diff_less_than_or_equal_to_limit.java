class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left=0,maxlen=0,window;
        Deque<Integer> minq=new ArrayDeque<>(),maxq=new ArrayDeque<>();

        for(int right=0;right<nums.length;right++){
            window=right-left+1;

            while(!minq.isEmpty() && nums[minq.peekLast()] >= nums[right])
                minq.removeLast();
            
            while(!maxq.isEmpty() && nums[maxq.peekLast()] <= nums[right])
                maxq.removeLast();
            
            minq.addLast(right);
            maxq.addLast(right);

            while(nums[maxq.peekFirst()] - nums[minq.peekFirst()] > limit){
                left++;
                if(maxq.peekFirst()<left)
                    maxq.removeFirst();
                if(minq.peekFirst()<left)
                    minq.removeFirst();
                window--;
            }
            maxlen=Math.max(maxlen,window);
        }
        return maxlen;
    }
}
