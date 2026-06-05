class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 1 ? 1 : -1;

            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return max;
        
        // int[] prefixsum = new int[nums.length];
        // int max=0;
        // HashMap<Integer,Integer> hashMap = new HashMap<>();
        // prefixsum[0] = nums[0] == 1 ? 1 : -1;
        // for (int i = 1; i < nums.length; i++) {
        //     if(nums[i] == 1){
        //         prefixsum[i] = prefixsum[i-1] + 1;
        //     } else if (nums[i] == 0) {
        //         prefixsum[i] = prefixsum[i-1] - 1;
        //     }           
        // }
        // hashMap.put(0,-1);
        // for (int i = 0; i < prefixsum.length; i++) {
        //     if(hashMap.containsKey(prefixsum[i])){
        //         max = Math.max(max,i-hashMap.get(prefixsum[i]));
        //     }else {
        //         hashMap.put(prefixsum[i],i);
        //     }
        // }
        // return max;
    }
}
