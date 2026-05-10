class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int area = (right - left) * Math.min(leftHeight, rightHeight);
            maxArea = Math.max(maxArea, area);
            if (leftHeight < rightHeight) {
                while (left < right &&
                       height[left] <= leftHeight) {
                    left++;
                }
            } else {
                while (left < right &&
                       height[right] <= rightHeight) {
                    right--;
                }
            }
        }
        return maxArea;
    
        // int left = 0;
        // int right = height.length - 1;
        // int maxArea = 0;
        // while (left < right) {
        //     int width = right - left;
        //     int minHeight = Math.min(height[left], height[right]);
        //     int area = width * minHeight;
        //     maxArea = Math.max(maxArea, area);
        //     if (height[left] < height[right]) {
        //         left++;
        //     } else {
        //         right--;
        //     }
        // }
        // return maxArea;
    }
}
