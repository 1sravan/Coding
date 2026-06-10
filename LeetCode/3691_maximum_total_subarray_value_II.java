import java.util.*;

class Solution {

    int[][] stMax;
    int[][] stMin;
    int[] log;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        buildSparseTables(nums);

        PriorityQueue<Node> pq =
            new PriorityQueue<>((a, b) -> Long.compare(b.val, a.val));

        for (int l = 0; l < n; l++) {
            long v = getValue(l, n - 1);
            pq.offer(new Node(l, n - 1, v));
        }

        long ans = 0;

        while (k-- > 0) {
            Node cur = pq.poll();

            ans += cur.val;

            if (cur.r > cur.l) {
                int nr = cur.r - 1;
                pq.offer(new Node(
                    cur.l,
                    nr,
                    getValue(cur.l, nr)
                ));
            }
        }

        return ans;
    }

    private long getValue(int l, int r) {
        return (long) queryMax(l, r) - queryMin(l, r);
    }

    private void buildSparseTables(int[] nums) {
        int n = nums.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int K = log[n] + 1;

        stMax = new int[n][K];
        stMin = new int[n][K];

        for (int i = 0; i < n; i++) {
            stMax[i][0] = nums[i];
            stMin[i][0] = nums[i];
        }

        for (int j = 1; j < K; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[i][j] = Math.max(
                    stMax[i][j - 1],
                    stMax[i + (1 << (j - 1))][j - 1]
                );

                stMin[i][j] = Math.min(
                    stMin[i][j - 1],
                    stMin[i + (1 << (j - 1))][j - 1]
                );
            }
        }
    }

    private int queryMax(int l, int r) {
        int len = r - l + 1;
        int j = log[len];

        return Math.max(
            stMax[l][j],
            stMax[r - (1 << j) + 1][j]
        );
    }

    private int queryMin(int l, int r) {
        int len = r - l + 1;
        int j = log[len];

        return Math.min(
            stMin[l][j],
            stMin[r - (1 << j) + 1][j]
        );
    }

    static class Node {
        int l;
        int r;
        long val;

        Node(int l, int r, long val) {
            this.l = l;
            this.r = r;
            this.val = val;
        }
    }
}
