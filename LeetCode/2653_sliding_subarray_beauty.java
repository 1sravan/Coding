class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] freq = new int[101];

        for (int i = 0; i < k; i++) {
            freq[nums[i] + 50]++;
        }
        ans[0] = findBeauty(freq, x);
        int idx = 1;
        for (int right = k; right < n; right++) {
            freq[nums[right - k] + 50]--;
            freq[nums[right] + 50]++;
            ans[idx++] = findBeauty(freq, x);
        }
        return ans;
    }

    private int findBeauty(int[] freq, int x) {
        int count = 0;
        for (int i = 0; i < 50; i++) {
            count += freq[i];

            if (count >= x) {
                return i - 50;
            }
        }

        return 0;
    }
}
