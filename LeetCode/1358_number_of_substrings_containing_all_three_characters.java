class Solution {
    public int numberOfSubstrings(String s) {
        int count = 0, left = 0;
        int[] freq = new int[3];
        for(int right = 0;right < s.length();right++){
            freq[s.charAt(right) - 'a']++;
            while(freq[0] >= 1 && freq[1] >=1 && freq[2] >= 1){
                count += s.length() - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return count;
    }
}
