class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0; i<2*nums.length;i++){
            int idx = i % nums.length;
            while(!stack.isEmpty() && nums[idx] > nums[stack.peek()]){
                res[stack.pop()] = nums[idx];
            }
            if(i < nums.length) stack.push(idx);
        }
        return res;
    }
}
