class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0;i < arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            left[i] = i - (stack.isEmpty()?-1:stack.peek());
            stack.push(i);
        }
        stack.clear();
        for(int i = arr.length-1;i >= 0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            right[i] = (stack.isEmpty()?arr.length:stack.peek()) - i;
            stack.push(i);
        }

        long sum = 0;
        int MOD = 1_000_000_007;
        for(int i=0;i<arr.length;i++){
            sum = (sum + (long) arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) sum;
    }
}
