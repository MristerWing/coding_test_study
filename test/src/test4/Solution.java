package test4;

import java.util.Stack;

public class Solution {
    public static int solution(String s) {
        Stack<String> stack = new Stack<>();

        String[] str = s.split("");

        stack.push(str[0]);
        for(int i = 1; i < str.length; i++) {
            String c = str[i];
            if(c.equals(stack.isEmpty() ? "" : stack.peek())) stack.pop();
            else stack.push(c);
        }

        return stack.size() == 0 ? 1: 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("cdcd"));
    }
}
