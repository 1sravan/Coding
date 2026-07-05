class Solution {
    public int compress(char[] chars) {
        int write = 0;
        for (int c = 0;c < chars.length;) {
            int left = c;
            while (left < chars.length && chars[c] == chars[left]){
                left++;
            }
            if(left-c > 1){
                chars[write++] = chars[c];
                String cnt = String.valueOf(left-c);
                for (char ch : cnt.toCharArray()) {
                    chars[write++] = ch;
                }
            }else{
                chars[write++] = chars[c];
            }
            c = left;
        }
        return write;
    }
}
