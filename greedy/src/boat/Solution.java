package boat;

import java.util.Arrays;

public class Solution {
    public static int solution(int[] people, int limit) {
        int answer = people.length;
        int startIndex = 0;
        Arrays.sort(people);

        for (int search = people.length - 1; search >= 0; search--) {


            if (people[search] + people[startIndex] <= limit) {
                answer--;
                startIndex++;
            }

            if (search == startIndex) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] people = {70, 50, 80, 80, 80, 90, 50};
        int limit = 100;

        System.out.println(solution(people, limit));
    }
}
