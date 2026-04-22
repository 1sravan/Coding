class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreqNum = nums[0];
        int maxFrequency = 0;
        for (int num : nums) {
            int count = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, count);
            if (count > maxFrequency) {
                maxFrequency = count;
                maxFreqNum = num;
            }
        }        
        return(maxFreqNum);
    }
}
