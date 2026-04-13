class Solution {
    public boolean isValid(String s) {

        char[] stack = new char[s.length()];
    int top = -1;

    for (char c : s.toCharArray()) {
        if (c == '(') stack[++top] = ')';
        else if (c == '{') stack[++top] = '}';
        else if (c == '[') stack[++top] = ']';
        else {
            if (top == -1 || stack[top--] != c) return false;
        }
    }

    return top == -1;
    
        // if (s.length()%2 != 0){
        //     return false;
        // }
        // else {
        //     Stack<Character> stack = new Stack<Character>();
        //     for (int i = 0; i < s.length(); i++) {
        //         if (stack.empty()){
        //             stack.add(s.charAt(i));
        //         }
        //         else if ((char)((int)stack.peek()+2) == s.charAt(i) ||
        //                  (char)((int)stack.peek()+1) == s.charAt(i)){
        //                 stack.pop();
        //         }else {
        //             stack.add(s.charAt(i));
        //         }
        //     }
        //     if (stack.empty())
        //         return(true);
        //     return false;
        // }
    }
}
