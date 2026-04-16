class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, max = 0;

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }

            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }

        return max;

        // Set<Character> set = new HashSet<>();
        // int left = 0, max = 0;

        // for (int right = 0; right < s.length(); right++) {
        //     while (set.contains(s.charAt(right))) {
        //         set.remove(s.charAt(left));
        //         left++;
        //     }

        //     set.add(s.charAt(right));
        //     max = Math.max(max, right - left + 1);
        // }

        // return max;


        // int count = 0,result = 0;
        // ArrayDeque<Character> adq = new ArrayDeque<Character>();
        // for (int i = 0; i < s.length(); i++) {
        //     while(adq.contains(s.charAt(i))) {
        //         adq.removeFirst();
        //         count--;
        //     }
        //     adq.add(s.charAt(i));
        //     count++;
        //     result = Math.max(count,result);
        // }
        // return(result);
    }
}
