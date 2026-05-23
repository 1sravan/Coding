class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[(i + 1) % n]) {
                count++;
            }
        }
        return(count <= 1);
    }
}
