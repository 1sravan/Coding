class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAltitude = 0;

        for (int g : gain) {
            altitude += g;
            maxAltitude = Math.max(maxAltitude, altitude);
        }
        return maxAltitude;
    
        // int [] result = new int[gain.length+1];

        // int max=0;
        // for (int i = 1; i <= gain.length; i++) {
        //     result[i] = gain[i-1] + result[i-1];
        //     if(result[i] > max) max=result[i];
        // }
        // return(max);
    }
}
