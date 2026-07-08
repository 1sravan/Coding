class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> outerList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int left=j+1,right=nums.length-1;
                while(left < right){
                    long sum = (long)target - nums[i] - nums[j];
                    if((long)nums[left]+nums[right] == sum){
                        outerList.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++;right--;
                    }
                    else if((long)nums[left] + nums[right] < sum) left++;
                    else right--;
                }
            }
        }
        return outerList;
    }
}
