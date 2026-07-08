class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> hashmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hashmap.put(s.charAt(i),i);
        }
        for(int i=0;i<s.length();i++){
            int start = i;
            int end = hashmap.get(s.charAt(i));
            for(int j=start;j<=end;j++){
                end = Math.max(end,hashmap.get(s.charAt(j)));
            }
            list.add(end-start+1);
            i = end;
        }
        return list;
    }
}
