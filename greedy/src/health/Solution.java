package health;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static int solution(int n, int[] lost, int[] reserve) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> over = new ArrayList<>();
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int student : reserve) {
            if(map.containsValue(student)) {
                map.remove(student -1);
                over.add(student);
                continue;
            }
            for (int l : lost) {
                if(map.containsValue(l)) continue;
                if (student - 1 == l || student + 1 == l) {
                    if (!map.containsKey(student) && over.indexOf(l) == -1) map.put(student, l);
                } else if(student == l) {
                    over.add(student);
                    map.remove(student);
                    break;
                }
            }
        }

        System.out.println(map);
        return n - lost.length + over.size() + map.size();
    }

    public static void main(String[] args) {
        int n = 8;
        int[] lost = {4,5};
        int[] reserve = {5,6};

        System.out.println("result: " + solution(n, lost, reserve));
    }
}
