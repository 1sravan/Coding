class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       int count=0;
        int[] prefix = new int[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        
        prefix[0] = (nums[0] % 2 == 1)?1:0;
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + ((nums[i] % 2 == 1)?1:0);
        }
        // System.out.println(Arrays.toString(prefix));

        map.put(0,1);
        for (int i=0;i< prefix.length;i++){
            if(map.containsKey(prefix[i]-k)){
                count += map.get(prefix[i]-k);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i],0)+1);
        }
        return count;
    }
}
