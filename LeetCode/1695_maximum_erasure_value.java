class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0,max = 0, sum = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int right = 0; right < nums.length;right++){
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                sum -= nums[left++];
            }
            set.add(nums[right]);
            sum += nums[right];
            max = Math.max(max,sum);
        }
        return max;
    }
}
