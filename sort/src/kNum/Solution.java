package kNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int indexNum = 0;

        for(int[] c : commands) {
            // 배열 변환
            List<Integer>tmp = new ArrayList<>();
            for(int i = 0; i < array.length;i++) {
                if(i >= c[0] - 1 && i <= c[1] - 1) {
                    tmp.add(array[i]);
                }
            }
            tmp.sort(Comparator.naturalOrder());
            answer[indexNum++] = tmp.get(c[2] - 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(Arrays.toString(solution(array, commands)));
    }
}
