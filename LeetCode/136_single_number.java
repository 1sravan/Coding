class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
    
    return result;
        // HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        // for (int num : nums) {
        //     if (hashmap.containsKey(num)) {
        //         hashmap.put(num, hashmap.get(num) + 1);
        //     } else {
        //         hashmap.put(num, 1);
        //     }
        // }
        // for (Map.Entry<Integer, Integer> map : hashmap.entrySet()) {
        //     System.out.println(map.getKey() + "  " + map.getValue());
        //     if (map.getValue() == 1){
        //         return(map.getKey());
        //     }
        // }
        // return 0;

    }
}
