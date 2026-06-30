class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0,usedBits = 0,max = 0;
        for(int right = 0;right < nums.length;right++){
            while((usedBits & nums[right]) != 0)
                usedBits ^= nums[left++];
            usedBits |= nums[right];
            max = Math.max(max,right - left + 1);
        }
        return max;
    }
}
