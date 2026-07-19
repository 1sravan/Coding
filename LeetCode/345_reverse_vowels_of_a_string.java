class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;

        while (left < right) {
            if (!vowels.contains(String.valueOf(chars[left]))) {
                left++;
            } else if (!vowels.contains(String.valueOf(chars[right]))) {
                right--;
            } else {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}   
