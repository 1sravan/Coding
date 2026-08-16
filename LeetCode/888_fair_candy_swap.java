class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0, sumB = 0;
        Set<Integer> bobSet = new HashSet<>();
        
        for (int a : aliceSizes) sumA += a;
        for (int b : bobSizes) {
            sumB += b;
            bobSet.add(b);
        }
        
        int diff = (sumA - sumB) / 2;
        for (int a : aliceSizes) {
            int target = a - diff;
            if (bobSet.contains(target)) {
                return new int[]{a, target};
            }
        }
        return new int[0];
    }
}   
