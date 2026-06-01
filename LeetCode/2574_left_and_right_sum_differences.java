class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            result[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }

        return result;
        
        // int [] prefixsum = new int[nums.length];
        // int [] suffixsum = new int[nums.length];
        // int [] result = new int[nums.length];

        // prefixsum[0] = 0;
        // for (int i = 1; i < nums.length; i++) {
        //     prefixsum[i] = prefixsum[i-1] +  nums[i-1];
        // }
        // suffixsum[nums.length-1] = 0;
        // for (int i = nums.length-2; i >=0 ; i--) {
        //     suffixsum[i] = suffixsum[i+1] +  nums[i+1];
        // }
        // for (int i = 0; i < nums.length; i++) {
        //     result[i] = Math.abs(prefixsum[i] - suffixsum[i]);
        // }
        // return(result);
    }
}
