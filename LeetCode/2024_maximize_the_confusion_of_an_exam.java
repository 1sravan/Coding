class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k){
        return Math.max(computeWindow(answerKey,k,'F'),computeWindow(answerKey,k,'T'));
    }
    public int computeWindow(String answerKey, int k,char s) {
        int left = 0,max = 0, freq = 0;
        for(int right = 0;right < answerKey.length();right++){
            if(answerKey.charAt(right) == s){
                freq++;
            }
            while(freq > k){
                if(answerKey.charAt(left) == s) freq--;
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}
