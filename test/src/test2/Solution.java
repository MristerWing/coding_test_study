package test2;

public class Solution {
    public static int solution(int n, int a, int b) {
        int answer = 1;
        int round = n > 2 ? (n / 2) - 1 : n / 2;

        while (round > 0) {
            a = a % 2 == 1 ? (a + 1) / 2 : a / 2;
            b = b % 2 == 1 ? (b + 1) / 2 : b / 2;
            answer++;
            round--;
            if(Math.abs(a - b) == 1) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7));
    }
}
