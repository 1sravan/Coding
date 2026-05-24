class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] >= goal - (i - 1)) {
                goal = i - 1;
            }
        }
        return goal == 0;
    }
}
