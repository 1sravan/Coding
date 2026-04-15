class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int current = map.get(key) + map.get(key + 1);
                max = Math.max(max, current);
            }
        }

        return max;

    //     HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    //     for (int num : nums) {
    //         if (map.containsKey(num)) {
    //             map.put(num, map.get(num) + 1);
    //         } else {
    //             map.put(num, 1);
    //         }
    //     }
    //     int count = 0;
    //     List<Integer> keys = new ArrayList<>(map.keySet());
    //     int max = 0,current=0;
    //     Set<Integer> set = new HashSet<>();
    //     for (int i = 0; i < map.size(); i++) {
    //         for (int j = 1; j < map.size(); j++) {
    //             if (Math.abs(keys.get(i) - keys.get(j)) == 1){
    //                 count = map.get(keys.get(i)) + map.get(keys.get(j));
    //                 if (count > current){
    //                     current = count;
    //                 }
    //             }
    //         }
    //     }
    //     return current;
    }
}
