package test3;

import java.util.Arrays;

public class Solution {
    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int n = 2;

        if (red == 1) {
            answer[0] = 3;
            answer[1] = 3;
        } else {
            while (n <= 5000) {
                if (red % n == 0) {
                    int weight = red / n + 2;
                    int height = n + 2;
                    if(height > weight) {
                        int tmp = weight;
                        weight = height;
                        height = tmp;
                    }

                    if (weight * 2 + ((height * 2) - 4) == brown) {
                        answer[0] = weight;
                        answer[1] = height;
                        break;
                    }
                }

                n++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
    }
}
