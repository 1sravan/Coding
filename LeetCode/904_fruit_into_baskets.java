class Solution {
    public int totalFruit(int[] fruits) {
        int left=0,max=0;
        HashMap<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        for(int right=0;right<fruits.length;right++){
            hashMap.put(fruits[right],hashMap.getOrDefault(fruits[right],0)+1);
            while(hashMap.size()>2){
                hashMap.put(fruits[left],hashMap.get(fruits[left])-1);
                if(hashMap.get(fruits[left]).equals(0)){
                    hashMap.remove(fruits[left]);
                }
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
