class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0;
        int[] prefix = new int[nums.length];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        // System.out.println(Arrays.toString(prefix));

        for (int i = 0; i < prefix.length; i++) {
            int temp = ((prefix[i]%k)+k)%k;
            hashMap.put(temp, hashMap.getOrDefault(temp,0)+1);
        }
        for (Map.Entry<Integer,Integer> map : hashMap.entrySet()) {
            int freq = map.getValue();
            if(map.getKey() == 0){
                count+= freq * (freq + 1) / 2;
            }else {
                count += freq * (freq - 1) / 2;
            }
        }
        return count;
    }
}
