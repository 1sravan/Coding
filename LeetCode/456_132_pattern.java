class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;

        Stack<Integer> stack = new Stack<Integer>();
        int thirdVal = Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] < thirdVal) return true;
            while(!stack.isEmpty() && nums[i] > stack.peek()){
                thirdVal = stack.pop();
            }
            stack.push(nums[i]);
        }

        return false;
    }
}
