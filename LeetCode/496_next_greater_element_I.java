class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0) return new int[]{};
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                stack.pop();
            }
            hashMap.put(nums2[i],stack.isEmpty()?-1:stack.peek());
            stack.push(nums2[i]);
        }
        
        // for(int i=0;i<nums2.length;i++){
        //     int j=i+1;
        //     while(j < nums2.length && nums2[j] < nums2[i]){
        //         j++;
        //     }
        //     hashMap.put(nums2[i],(j >= nums2.length)?-1:nums2[j]);
        // }
        
        for(int i=0;i<nums1.length;i++){
            nums1[i]=hashMap.get(nums1[i]);
        }
        return nums1;
    }
}
