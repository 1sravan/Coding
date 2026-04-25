class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whites = 0;
        for (int i = 0; i < k; i++) {
            whites += (blocks.charAt(i) == 'W') ? 1 : 0;
        }
        int min = whites;
        for (int i = k; i < blocks.length(); i++) {
            whites += (blocks.charAt(i) == 'W') ? 1 : 0;
            whites -= (blocks.charAt(i - k) == 'W') ? 1 : 0;

            if (whites < min) min = whites;
        }
        return min;
    }
}
