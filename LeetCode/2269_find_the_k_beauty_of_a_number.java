class Solution {
    public int divisorSubstrings(int num, int k) {
        int count = 0;
        int divisor = (int) Math.pow(10, k - 1);
        int curr = 0;

        String s = String.valueOf(num);

        for (int i = 0; i < s.length(); i++) {
            curr = curr * 10 + (s.charAt(i) - '0');

            if (i >= k - 1) {
                if (curr != 0 && num % curr == 0) {
                    count++;
                }
                curr = curr % divisor;
            }
        }

        return count;
        
        // String s = String.valueOf(num);
        // int count = 0;

        // for (int i = 0; i <= s.length() - k; i++) {
        //     int val = Integer.parseInt(s.substring(i, i + k));

        //     if (val != 0 && num % val == 0) {
        //         count++;
        //     }
        // }

        // return count;
    }
}
