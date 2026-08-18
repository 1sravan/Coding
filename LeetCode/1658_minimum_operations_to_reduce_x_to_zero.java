class Solution {
    public int minOperations(int[] nums, int x) {
        int target=Arrays.stream(nums).sum()-x;
        if(target<0) return -1;

        int left=0,window=0,maxlen=-1;
        for(int i=0;i<nums.length;i++){
            window+=nums[i];
            while(window>target && left<=i)
                window-=nums[left++];
            if(window==target)
                maxlen=Math.max(maxlen,i-left+1);
        }
        return maxlen==-1?-1:nums.length-maxlen;
    }
}
