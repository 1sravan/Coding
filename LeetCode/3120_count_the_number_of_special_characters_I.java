class Solution {
    public int numberOfSpecialChars(String word) {

        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a'] = true;
            } else {
                upper[ch - 'A'] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                count++;
            }
        }
        return count;

        // HashSet<Character> lower = new HashSet<>();
        // HashSet<Character> upper = new HashSet<>();
        // for (char ch : word.toCharArray()) {
        //     if (Character.isLowerCase(ch)) {
        //         lower.add(ch);
        //     } else {
        //         upper.add(ch);
        //     }
        // }
        // int count = 0;
        // for (char ch : lower) {
        //     if (upper.contains(Character.toUpperCase(ch))) {
        //         count++;
        //     }
        // }
        // return(count);
    }
}
