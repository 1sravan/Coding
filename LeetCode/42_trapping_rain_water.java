class Solution {
    public int trap(int[] height) {
        int[] prefixsum = new int[height.length];
        int[] sufixsum = new int[height.length];

        int sum=0;

        prefixsum[0] = height[0];
        sufixsum[height.length-1] = height[height.length-1];

        for (int i = 1; i < height.length; i++) {
            prefixsum[i] = Math.max(prefixsum[i-1] , height[i]);
        }
        for (int i = height.length-2; i >= 0 ; i--) {
            sufixsum[i] =Math.max(sufixsum[i+1] , height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(prefixsum[i],sufixsum[i]) - height[i];
        }
        
        return(sum);

    }
}
