class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        long result=0;
        for(int i=0;i<nums.length;i++){
            result+=findRightmost(nums,upper,i)-findRightmost(nums,lower-1,i);
        }
        return result;
    }
    public int findRightmost(int[] nums,int range,int i){
        int left=i+1,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[i]+nums[mid]<=range){
                left=mid+1;
            }else if(nums[i]+nums[mid]>range){
                right=mid-1;
            }
        }
        return left;
    }
}
