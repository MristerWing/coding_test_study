package bignum;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static String solution(int[] numbers) {
        if(Arrays.stream(numbers).sum() == 0) return "0";
        List<String> tmp = Arrays.stream(numbers).mapToObj(Integer::toString).collect(Collectors.toList());

        Collections.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        return tmp.stream().reduce((e1, e2) -> e1 + e2).get();
    }

    public static void main(String[] args) {
        int[] numbers = {121, 12};
        System.out.println(solution(numbers));
    }
}
