class Solution {
    public String minWindow(String s, String t){
        int[] tfreq = new int[128];
        int[] sfreq = new int[128];
        int required = 0;
        for(int i = 0;i < t.length();i++){
            if(tfreq[t.charAt(i)] == 0) required++;
            tfreq[t.charAt(i)]++;
        }
        int left = 0,matched = 0;
        String res = "";
        for(int right = 0;right < s.length();right++){
            char c = s.charAt(right);
            sfreq[c]++;
            if(sfreq[c] == tfreq[c]) matched++;
            while(matched == required){
                String temp = s.substring(left,right + 1);
                if(res.isEmpty() || temp.length() < res.length()) res = temp;
                char leftChar = s.charAt(left);
                sfreq[leftChar]--;
                if(sfreq[leftChar] < tfreq[leftChar]) matched--;
                left++;
            }
        }
        return res;
    }

    // public String minWindow(String s, String t) {
    //     int[] tfreq = new int[128];
    //     int[] sfreq = new int[128];

    //     for(int i = 0;i < t.length();i++) tfreq[t.charAt(i)]++;
    //     int left=0;
    //     String res = "";
    //     for(int right = 0;right < s.length();right++){
    //         sfreq[s.charAt(right)]++;
    //         while(freqCheck(tfreq,sfreq)){
    //             String temp = s.substring(left,right + 1);
    //             if(res.isEmpty() || temp.length() < res.length()) res = temp;
    //             sfreq[s.charAt(left)]--;
    //             left++;
    //         }
    //     }
    //     return res;
    // }

    // private static boolean freqCheck(int[] tfreq,int[] sfreq){
    //     for(int i = 0; i < 128;i++){
    //         if(tfreq[i] > 0){
    //             if(!(sfreq[i] >= tfreq[i])) return false;
    //         }
    //     }
    //     return true;
    // }
}
