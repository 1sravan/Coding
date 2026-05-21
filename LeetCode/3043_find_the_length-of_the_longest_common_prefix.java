class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            while (num > 0) {
                set.add(num);
                num /= 10;
            }
        }

        int max = 0;
        for (int num : arr2) {
            while (num > 0) {
                if (set.contains(num)) {
                    max = Math.max(max,String.valueOf(num).length());
                }
                num /= 10;
            }
        }
        return max;
        
        // HashSet<String> set = new HashSet<>();
        // for (int num : arr1) {
        //     String s = String.valueOf(num);
        //     String prefix = "";
        //     for (int i = 0; i < s.length(); i++) {
        //         prefix += s.charAt(i);
        //         set.add(prefix);
        //     }
        // }
        // int max = 0;
        // for (int num : arr2) {
        //     String s = String.valueOf(num);
        //     String prefix = "";
        //     for (int i = 0; i < s.length(); i++) {
        //         prefix += s.charAt(i);
        //         if (set.contains(prefix)) {
        //             max = Math.max(max, prefix.length());
        //         }
        //     }
        // }
        // return(max);

        // int max = 0;
        // for (int i = 0; i < arr1.length; i++) {
        //     String a = String.valueOf(arr1[i]);
        //     for (int j = 0; j < arr2.length; j++) {
        //         String b = String.valueOf(arr2[j]);
        //         int len = Math.min(a.length(), b.length());
        //         int count = 0;
        //         for (int k = 0; k < len; k++) {
        //             if (a.charAt(k) == b.charAt(k)) {
        //                 count++;
        //             } else {
        //                 break;
        //             }
        //         }
        //         max = Math.max(max, count);
        //     }
        // }
        // return(max);
    }
}
