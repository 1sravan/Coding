class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                rQueue.offer(i);
            } else {
                dQueue.offer(i);
            }
        }
        while (!rQueue.isEmpty() && !dQueue.isEmpty()) {
            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();
            if (rIndex < dIndex) {
                rQueue.offer(rIndex + n);
            } else {
                dQueue.offer(dIndex + n);
            }
        }
        return rQueue.isEmpty() ? "Dire" : "Radiant";
    }
}   
