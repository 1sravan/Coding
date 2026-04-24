class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) { 
                return true;
            }
        }
        return false;

    //     HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
    //     for(int i = 0;i < nums.length; i++){
    //         if(hashmap.containsKey(nums[i])){
    //             return(true);
    //         }else{
    //             hashmap.put(nums[i],1);
    //         }
    //     }
    //     return false;
    }
}
