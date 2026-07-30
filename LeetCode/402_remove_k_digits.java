class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<num.length();i++){
            int digit = num.charAt(i) - '0';
            while(!stack.isEmpty() && k > 0 && stack.peek() > digit){
                stack.pop();k--;
            }
            stack.push(digit);
        }
        while(k>0){
            stack.pop();k--;
        }
        StringBuilder sb = new StringBuilder();
        for(int d:stack) sb.append(d);
        String res = sb.toString().replaceFirst("^0+(?!$)","");
        
        return res.isEmpty()?"0":res;
    }
    
}
