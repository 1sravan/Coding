class Solution {

    private String s;
    private long[][][][][] cntMemo;
    private long[][][][][] sumMemo;
    private boolean[][][][][] vis;

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }

    private long solve(long n) {
        if (n <= 0) return 0;

        s = String.valueOf(n);

        int len = s.length();

        cntMemo = new long[len][11][11][3][2];
        sumMemo = new long[len][11][11][3][2];
        vis = new boolean[len][11][11][3][2];

        return dfs(0, 10, 10, 1, 0, true)[1];
    }

    private long[] dfs(int pos,
                       int prev2,
                       int prev1,
                       int cmp,
                       int started,
                       boolean tight) {

        if (pos == s.length()) {
            return new long[]{started == 1 ? 1 : 0, 0};
        }

        int cmpIdx = cmp + 1;

        if (!tight && vis[pos][prev2][prev1][cmpIdx][started]) {
            return new long[]{
                    cntMemo[pos][prev2][prev1][cmpIdx][started],
                    sumMemo[pos][prev2][prev1][cmpIdx][started]
            };
        }

        int limit = tight ? s.charAt(pos) - '0' : 9;

        long totalCount = 0;
        long totalWave = 0;

        for (int d = 0; d <= limit; d++) {

            boolean nextTight = tight && (d == limit);

            if (started == 0 && d == 0) {
                long[] nxt = dfs(pos + 1, 10, 10, 1, 0, nextTight);

                totalCount += nxt[0];
                totalWave += nxt[1];
                continue;
            }

            if (started == 0) {
                long[] nxt = dfs(pos + 1, 10, d, 1, 1, nextTight);

                totalCount += nxt[0];
                totalWave += nxt[1];
            }
            else if (prev2 == 10) {
                int newCmp = Integer.compare(d, prev1);

                long[] nxt = dfs(pos + 1, prev1, d, newCmp, 1, nextTight);

                totalCount += nxt[0];
                totalWave += nxt[1];
            }
            else {
                int newCmp = Integer.compare(d, prev1);

                long add = (cmp != 0 && newCmp != 0 && cmp != newCmp) ? 1 : 0;

                long[] nxt = dfs(pos + 1, prev1, d, newCmp, 1, nextTight);

                totalCount += nxt[0];
                totalWave += nxt[1] + add * nxt[0];
            }
        }

        if (!tight) {
            vis[pos][prev2][prev1][cmpIdx][started] = true;
            cntMemo[pos][prev2][prev1][cmpIdx][started] = totalCount;
            sumMemo[pos][prev2][prev1][cmpIdx][started] = totalWave;
        }

        return new long[]{totalCount, totalWave};
    }
}
