class Solution {
    public int mySqrt(int x) {
        int left = 1,right = x,temp = -1;
        while(left <= right){
            int mid = (right + left) / 2;
            if(mid <= x / mid){
                left = mid+1;
            }else{
                temp = mid;
                right = mid-1;
            }
        }
        if(temp == -1) return x;
        return temp-1;
    }
}
