class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1,right = Arrays.stream(piles).max().getAsInt();

        while(left <= right){
            int mid = left + (right-left)/2;
            long consume =0;
            for(int pile : piles)
                consume+=(pile+mid-1)/mid;
            if(consume<=h) right = mid-1;
            else left = mid+1;
        }

        return left;
    }
}
