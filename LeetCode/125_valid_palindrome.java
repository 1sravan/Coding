class Solution {
    public boolean isPalindrome(String s) {

        if (s == null) return false;
    int left = 0, right = s.length() - 1;
    
    while (left < right) {
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) 
            left++;
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) 
            right--;
        
        if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
            return false;
        
        left++;
        right--;
    }
    return true;

        // String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        // String reversed = new StringBuilder(clean).reverse().toString();
        // if(clean.equals(reversed))
        //     return true;
        // return false;
    }
}
