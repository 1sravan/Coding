class Solution {
    public boolean isPalindrome(int x) {
    //      if (x < 0 || (x % 10 == 0 && x != 0)) {
    //     return false;
    // }

    // int reversedHalf = 0;

    // while (x > reversedHalf) {
    //     reversedHalf = reversedHalf * 10 + (x % 10);
    //     x /= 10;
    // }
    // return x == reversedHalf || x == reversedHalf / 10;

        int y=x,res=0;
        if(x<0)
            return false;
        while(x>0){
            res = res*10 + (x%10);
            x /= 10; 
        }
        if(res==y)
            return true;
        return false;
    }
}
