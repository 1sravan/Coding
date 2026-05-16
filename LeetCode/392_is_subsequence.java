class Solution {

      private static int upperBound(List<Integer> list, int target) {

        int left = 0;
        int right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public boolean isSubsequence(String s, String t) {

        List<Integer>[] indexMap = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            indexMap[i] = new ArrayList<>();
        }
        for (int i = 0; i < t.length(); i++) {
            indexMap[t.charAt(i) - 'a'].add(i);
        }
        int prevIndex = -1;
        for (char c : s.toCharArray()) {
            List<Integer> positions = indexMap[c - 'a'];
            int next = upperBound(positions, prevIndex);
            if (next == positions.size()) {
                return false;
            }
            prevIndex = positions.get(next);
        }
        return true;

        // int j = 0;
        // for (int i = 0; i < t.length(); i++) {
        //     if (j < s.length() && s.charAt(j) == t.charAt(i)){
        //         j++;
        //     }
        // }
        // return j==s.length();
    }
}
