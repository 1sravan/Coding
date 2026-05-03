class NumArray {
     int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) return prefix[right];
        return prefix[right] - prefix[left - 1];
    }

    // int [] arr;
    // public NumArray(int[] nums) {
    //     arr= new int[nums.length];
    //     this.arr = nums;
    // }
    
    // public int sumRange(int left, int right) {
    //     int sum=0;
    //     while(left<= right){
    //         sum+=arr[left];
    //         left++;
    //     }
    //     return sum;
    // }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
