package test5;

public class Solution {

    public static boolean solution(String s) {
        char[] str = s.toCharArray();
        if (str[0] == ')' && str[str.length - 1] == '(') return false;
        char[] stack = new char[str.length];
        stack[0] = str[0];
        int peek = 0;
        for (int i = 1; i < str.length; i++) {
            // pop
            if (')' == str[i] && stack[peek] == '(') {
                stack[peek] = ' ';
                if(peek != 0) peek--;

            } else { //push
                if (stack[peek] == '(' || stack[peek] == ')') peek++;
                stack[peek] = str[i];
            }
        }

        boolean answer = peek == 0 && stack[peek] == ' ';
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("(())()()()"));
    }
}
