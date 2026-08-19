class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(nums.length==0 && k==0) return -1;
        return atMost(nums,k)-atMost(nums,k-1);
    }

    public int atMost(int[] nums,int k){
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        int left=0,count=0;
        for(int right=0;right<nums.length;right++){
                hashmap.put(nums[right],hashmap.getOrDefault(nums[right],0)+1);
                while(hashmap.size()>k){
                    hashmap.put(nums[left],hashmap.get(nums[left])-1);
                    if(hashmap.get(nums[left])==0)
                        hashmap.remove(nums[left]);
                    left++;
                }
                count+=right-left+1;
        }
        return count;
    }
}
