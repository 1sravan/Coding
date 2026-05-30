class Solution {
    public int maxRotateFunction(int[] nums) {
        
        int n = nums.length;
        long sum = 0;
        long f = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }
        long max = f;
        for (int k = 1; k < n; k++) {
            f = f + sum - (long) n * nums[n - k];
            max = Math.max(max, f);
        }
        return (int) max;
        
        // TLE
        // int max=Integer.MIN_VALUE;
        // for (int j = 0; j < nums.length; j++) {
        //     int sum =0 ;
        //     for(int i = 0; i < nums.length; i++) {
        //         sum += i * nums[(j + i) % nums.length];
        //     }
        //     max = Math.max(max, sum);    
        // }
        // return(max);
    }
}
