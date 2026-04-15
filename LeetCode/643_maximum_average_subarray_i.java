class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return((double) maxSum / k);
    }
    // static int sumval(int i, int j, int[] arr){
    //     int sum = 0;
    //     for ( ;i<=j;i++) {
    //         sum += arr[(i)];
    //     }
    //     return sum;
    // }
    // public double findMaxAverage(int[] nums, int k) {
    //     if(nums.length == 1)
    //         return (double)nums[0]/k;
    //     int j,sum=Integer.MIN_VALUE;
    //     for (int i = 0; i <= nums.length - k; i++) {
    //         j = i + k - 1;
    //         int temp = sumval(i, j, nums);
    //         if (temp > sum) {
    //             sum = temp;
    //         }
    //     }
    //     return((double) sum / k);
    // }
}
