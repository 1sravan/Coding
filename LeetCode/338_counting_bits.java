class Solution {
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i / 2] + (i % 2);
        }
        return bits;

        // int[] arr = new int[n+1];
        // for (int i = 0; i <= n; i++) {
        //     arr[i] = Integer.bitCount(i);
        // }
        // return arr;
    }
}
