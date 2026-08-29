class Solution {
    public long subArrayRanges(int[] nums) {

        Stack<Integer> maxStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        long result = 0;

        for (int i = 0; i <= nums.length; i++) {

            while (!maxStack.isEmpty() && (i == nums.length || nums[maxStack.peek()] <= nums[i])) {
               
                int mid = maxStack.pop();
                int left = maxStack.isEmpty() ? -1 : maxStack.peek();
                long contribution = (long) nums[mid] * (mid - left) * (i - mid);

                result += contribution;
            }

            while (!minStack.isEmpty() && (i == nums.length || nums[minStack.peek()] >= nums[i])) {

                int mid = minStack.pop();
                int left = minStack.isEmpty() ? -1 : minStack.peek();
                long contribution = (long) nums[mid] * (mid - left) * (i - mid);

                result -= contribution;
            }

            if (i < nums.length) {
                maxStack.push(i);
                minStack.push(i);
            }
        }

        return result;
    }
}
