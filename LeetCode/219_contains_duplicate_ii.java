class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) 
              return true;
            set.add(nums[i]);

            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
        
        // int start = 0;
        // LinkedList<Integer> list = new LinkedList<>();
        // for (int end = 0; end < nums.length; end++) {
        //     while(list.contains(nums[end])){
        //         list.removeFirst();
        //         System.out.println(start + " " + end);
        //         if (nums[start] == nums[end] && Math.abs(end - start)<=k){
        //             return(true);
        //         }
        //         start++;
        //     }
        //     list.add(nums[end]);
        // }
        // return(false);


        // for (int j = 0; j < nums.length; j++) {
        //     for (int l = 0; l < nums.length-1; l++) {
        //         if (nums[j] == nums[l] && Math.abs(j-l) <= k && j != l){
        //             return true;
        //         }
        //     }
        // }
        // return false;
    }
}
