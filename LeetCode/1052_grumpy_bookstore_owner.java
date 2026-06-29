class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0,sum = 0,left = 0,max = 0;
        for(int right = 0;right < grumpy.length;right++){
            if(grumpy[right] == 0)
                ans += customers[right];
            if(grumpy[right] == 1)
                sum += customers[right];
            while(right - left + 1 > minutes){
                if(grumpy[left] == 1)
                    sum -= customers[left];
                left++;
            }
                
            max = Math.max(max,sum);
        }
        return ans + max;
    }
}
