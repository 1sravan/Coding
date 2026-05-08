class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }
        int[] pFreq = new int[26];
        int[] wFreq = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pFreq[p.charAt(i) - 'a']++;
            wFreq[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(pFreq, wFreq)) {
            res.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            wFreq[s.charAt(i) - 'a']++;
            wFreq[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(pFreq, wFreq)) {
                res.add(i - p.length() + 1);
            }
        }

        return res;

        // List<Integer> res = new ArrayList<>();
        // char[] target = p.toCharArray();
        // Arrays.sort(target);
        // for (int i = 0; i <= s.length() - p.length(); i++) {
        //     String sub = s.substring(i, i + p.length());
        //     char[] arr = sub.toCharArray();
        //     Arrays.sort(arr);
        //     if (Arrays.equals(target, arr)) {
        //         res.add(i);
        //     }
        // }
        // return res;
    }
}



     
