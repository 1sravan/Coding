import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; ) {
            int start = nums[i];

            while (i + 1 < n && nums[i + 1] - nums[i] == 1) {
                i++;
            }

            result.add(start == nums[i] 
                ? String.valueOf(start) 
                : start + "->" + nums[i]);

            i++;
        }

        return result;
    }
}
