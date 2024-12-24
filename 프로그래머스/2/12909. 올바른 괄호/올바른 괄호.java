import java.util.Stack;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        int close_cnt = 0;
        int open_cnt = 0;
        while (!stack.isEmpty()) {
            Character c = stack.pop();
            switch (c) {
                case ')':
                    close_cnt++;break;
                case '(':
                    open_cnt++;
                    if (open_cnt > close_cnt) {
                        return false;
                    } else {
                        break;
                    }
                default:
                    return false;
            }
        }
        return open_cnt == close_cnt;
    }
}