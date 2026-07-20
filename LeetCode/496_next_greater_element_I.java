class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            int j=i+1;
            while(j < nums2.length && nums2[j] < nums2[i]){
                j++;
            }
            hashMap.put(nums2[i],(j >= nums2.length)?-1:nums2[j]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i]=hashMap.get(nums1[i]);
        }
        return nums1;
    }
}
