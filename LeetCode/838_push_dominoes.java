class Solution {
    public String pushDominoes(String dominoes) {
        String s = 'L' + dominoes + 'R';
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        for(int j = 1; j < s.length();j++){
            if(s.charAt(j) == '.') continue;
            if(s.charAt(i) == 'R' && s.charAt(j) == 'L'){
                int left = i + 1,right = j - 1;
                while(left < right){
                    sb.setCharAt(left++,'R');
                    sb.setCharAt(right--,'L');
                }
            }else if(s.charAt(i) == s.charAt(j)){
                for(int k = i + 1;k < j;k++) sb.setCharAt(k,s.charAt(i));
            }
            i = j;
        }
        return sb.substring(1,sb.length()-1);

    }
}
