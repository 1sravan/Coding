class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int[] prevSmaller = new int[heights.length];

        for(int i=0;i<heights.length;i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) stack.pop();
            prevSmaller[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        int[] nextSmaller = new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            nextSmaller[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(i);
        }
        
        int max = 0;
        for(int i=0;i<heights.length;i++){
            int width = nextSmaller[i] == -1 ? heights.length : nextSmaller[i];
            width -= prevSmaller[i] + 1;
            int area = heights[i] * width;
            max = Math.max(max,area);
        }

        return max;
    }
}
