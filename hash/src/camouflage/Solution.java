package camouflage;

import java.util.*;

public class Solution {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> hash = new HashMap<>();
        int answer = 1;
        for(String[] cloth : clothes) {
            if(!hash.containsKey(cloth[1])) {
                hash.put(cloth[1], 1);
            }else {
                hash.replace(cloth[1], hash.get(cloth[1]) + 1);
            }
        }

        for(int val : hash.values()) {
            answer *= val + 1;
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println("result: " + solution(clothes));
    }
}
