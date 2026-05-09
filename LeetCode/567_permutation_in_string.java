class Solution {
    public boolean checkInclusion(String s1, String s2) {
       if (s1.length() > s2.length()) 
            return false;

        int[] s1Freq = new int[26];
        int[] wFreq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            wFreq[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Freq, wFreq)) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            wFreq[s2.charAt(i) - 'a']++;
            wFreq[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(s1Freq, wFreq)) {
                return true;
            }
        }
        return false;

        // char[] s1c = s1.toCharArray();
        // Arrays.sort(s1c);
        // for (int i = 0; i <= s2.length() - s1.length(); i++) {
        //     char[] window = s2.substring(i, i + s1.length()).toCharArray();
        //     Arrays.sort(window);
        //     if (Arrays.equals(s1c, window)) {
        //         return true;
        //     }
        // }
        // return false;
    }
}
