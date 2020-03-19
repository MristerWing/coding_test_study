package more_hot;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.naturalOrder());
        queue.addAll(Arrays.stream(scoville).filter(e -> e < K).boxed().collect(Collectors.toList()));

        while (queue.size() > 1 && queue.peek() < K) {
            queue.offer(queue.poll() + (queue.poll() * 2));
            answer++;
        }

        return queue.peek() < K ? -1 : answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;

        System.out.println("result: " + solution(scoville, k));
    }
}
