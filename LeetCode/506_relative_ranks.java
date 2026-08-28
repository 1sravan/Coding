class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] indices = new Integer[n];

        Arrays.setAll(indices, i -> i);
        Arrays.sort(indices, (index1, index2) -> score[index2] - score[index1]);

        String[] result = new String[n];
        String[] medals = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
        
        for (int rank = 0; rank < n; rank++) {
            int originalIndex = indices[rank];
            if (rank < 3) {
                result[originalIndex] = medals[rank];
            } else {
                result[originalIndex] = String.valueOf(rank + 1);
            }
        }
      
        return result;
    }
}
