class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
                ans[i]++;
            }
            if (!stack.isEmpty()) {
                ans[i]++;
            }
            stack.push(i);
        }
        return ans;
    }
}
