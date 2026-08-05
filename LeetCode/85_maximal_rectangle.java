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

    public int maximalRectangle(char[][] matrix) {
        int max = 0;
        int[] heights = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == '1') heights[j] += 1;
                else heights[j] = 0;
            }
            max = Math.max(max,largestRectangleArea(heights));
        }

        return max;
    }
}
