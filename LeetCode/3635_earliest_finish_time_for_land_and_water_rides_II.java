import java.util.*;

class Solution {

    public int earliestFinishTime(int[] landStartTime,int[] landDuration,int[] waterStartTime,int[] waterDuration) {

        RideData water = new RideData(waterStartTime, waterDuration);

        RideData land =  new RideData(landStartTime, landDuration);

        long ans = Long.MAX_VALUE;

        // Land -> Water
        for (int i = 0; i < landStartTime.length; i++) {

            long finishLand = (long) landStartTime[i] + landDuration[i];

            ans = Math.min(ans,water.bestFinishAfter(finishLand)
            );
        }

        // Water -> Land
        for (int i = 0; i < waterStartTime.length; i++) {

            long finishWater = (long) waterStartTime[i] + waterDuration[i];

            ans = Math.min(ans,land.bestFinishAfter(finishWater));
        }

        return (int) ans;
    }

    static class RideData {

        int n;
        int[] start;
        int[] prefixMinDuration;
        long[] suffixMinFinish;

        RideData(int[] starts, int[] durations) {

            n = starts.length;

            int[][] rides = new int[n][2];

            for (int i = 0; i < n; i++) {
                rides[i][0] = starts[i];
                rides[i][1] = durations[i];
            }

            Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));

            start = new int[n];
            prefixMinDuration = new int[n];
            suffixMinFinish = new long[n];

            for (int i = 0; i < n; i++) {
                start[i] = rides[i][0];
            }

            prefixMinDuration[0] = rides[0][1];

            for (int i = 1; i < n; i++) {
                prefixMinDuration[i] = Math.min(prefixMinDuration[i - 1],rides[i][1]);
            }

            suffixMinFinish[n - 1] = (long) rides[n - 1][0] + rides[n - 1][1];

            for (int i = n - 2; i >= 0; i--) {

                long cur = (long) rides[i][0] + rides[i][1];

                suffixMinFinish[i] = Math.min(cur, suffixMinFinish[i + 1]);
            }
        }

        long bestFinishAfter(long T) {

            int idx = upperBound(start, T);

            long ans = Long.MAX_VALUE;

            // start <= T
            if (idx >= 0) {
                ans = Math.min(ans,T + prefixMinDuration[idx]);
            }

            // start > T
            if (idx + 1 < n) {
                ans = Math.min(ans,suffixMinFinish[idx + 1]);
            }

            return ans;
        }

        private int upperBound(int[] arr, long target) {

            int l = 0;
            int r = arr.length - 1;
            int ans = -1;

            while (l <= r) {

                int mid = l + (r - l) / 2;

                if (arr[mid] <= target) {
                    ans = mid;
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            return ans;
        }
    }
}
