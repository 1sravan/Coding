class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }

        return true;
        
        // StringBuilder sb = new StringBuilder(s);
        // StringBuilder st = new StringBuilder(t);
        // for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
        //     int index = st.indexOf(String.valueOf(sb.charAt(i)));
        //     if (index != -1){
        //         st.setCharAt(index,' ');
        //         sb.setCharAt(i,' ');
        //     }
        // }
        // return(st.toString().isBlank() && sb.toString().isBlank());
    }
}
