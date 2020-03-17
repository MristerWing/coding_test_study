package ramen;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        // 우선순위 큐
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Comparator.reverseOrder());
        // 공급완료일
        int suply_date = 0;

        for (int i = 0; i < k; i++) {
            // stock이 0인지 확인
            if (--stock == 0) {
                int j = suply_date;
                while(j < dates.length && dates[i] <= i+1) {
                    pqueue.offer(supplies[j]);
                    j ++;
                }

                suply_date = j;
                answer ++;
                stock += pqueue.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;

        System.out.println(solution(stock, dates, supplies, k));
    }
}
