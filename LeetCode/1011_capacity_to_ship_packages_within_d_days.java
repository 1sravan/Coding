class Solution {

    static int calculateDays(int[] weights,int capacity){
        int day=0;
        for (int i=0;i<weights.length;i++){
            int j=i,sum=0;
            while(j<weights.length && sum+weights[j]<=capacity){
                sum+=weights[j++];
            }
            i=j-1;day++;
        }
        return day;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int left=Arrays.stream(weights).max().getAsInt(),right= Arrays.stream(weights).sum();
        while(left<=right){
            int mid=(left+right)/2;
            if(calculateDays(weights,mid)<=days) right=mid-1;
            else left=mid+1;
        }

        return left;
    }
}
