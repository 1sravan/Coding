class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums1) {
            if (map.getOrDefault(num, 0) > 0) {
                res.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;

        // Arrays.sort(nums1);
        // Arrays.sort(nums2);

        // int i = 0, j = 0;
        // List<Integer> res = new ArrayList<>();
        // while (i < nums1.length && j < nums2.length) {
        //     if (nums1[i] == nums2[j]) {
        //         res.add(nums1[i]);
        //         i++;
        //         j++;
        //     } 
        //     else if (nums1[i] < nums2[j]) {
        //         i++;
        //     } 
        //     else {
        //         j++;
        //     }
        // }

        // int[] result = new int[res.size()];
        // for (int k = 0; k < res.size(); k++) {
        //     result[k] = res.get(k);
        // }

        // return result;
    }
}
