class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String max = "";

        for (String word : dictionary) {
            int left = 0;

            for (int i = 0; i < s.length() && left < word.length(); i++) {
                if (word.charAt(left) == s.charAt(i)) {
                    left++;
                }
            }

            if (left == word.length()) {
                if (word.length() > max.length() ||
                    (word.length() == max.length() && word.compareTo(max) < 0)) {
                    max = word;
                }
            }
        }

        return max;
    }
}
