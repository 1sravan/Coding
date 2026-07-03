class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closestsum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0;i < nums.length;i++){
            int left = i+1,right = nums.length-1;
            while(right > left){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum-target) < Math.abs(closestsum-target)) closestsum = sum;
                else if(sum < target) left++;
                else if(sum > target) right--;
                else if(sum == target) return sum;
            }
        }
        return closestsum;
    }
}
