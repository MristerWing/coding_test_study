package test1;

import java.util.*;

public class Solution {
    public static int solution(String numbers) {
        int answer = 0;
        if (numbers.startsWith("0")) numbers = numbers.replaceFirst("0", "");
        String[] numArray = numbers.split("");
        Arrays.sort(numArray, Comparator.reverseOrder());
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        // 에라스토스테네스의 체
        int max = Integer.parseInt(Arrays.stream(numArray).reduce((e1, e2) -> e1 + e2).get());
        ArrayList<Boolean> primeList = new ArrayList<>(max + 1);
        // 0과 1을 소수에서 제외
        primeList.add(false);
        primeList.add(false);

        // 리스트의 요소를 true로 지정
        for (int i = 2; i <= max; i++)
            primeList.add(i, true);

        // 이후 2 * i의 배수를 제거
        for (int i = 2; i <= max; i++)
            for (int j = 2; i * j <= max; j++) primeList.set(i * j, false);

        // 배열의 요소중 0을 제외한 나머지 값을 키 값으로 지정, 이후 숫자를 구해서 소수판별
        for (int i = 0; i < numArray.length; i++) {
            int number = Integer.parseInt(numArray[i]);
            if (number == 0) continue;
            if (!map.containsKey(number)) {
                ArrayList<String> list = new ArrayList<>();
                if (primeList.get(number)) list.add(Integer.toString(number));
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                dfs(numArray, list, primeList, set, number);

                map.put(number, list);
                answer += list.size();
            }
        }

        System.out.println(map.toString());

        return answer;
    }

    public static void dfs(String[] numArray, ArrayList<String> list, ArrayList<Boolean> primeList, HashSet<Integer> set, int num) {
        for (int i = 0; i < numArray.length; i++) {
            if (set.contains(i)) continue;

            StringBuilder tmp = new StringBuilder();
            tmp.append(num + "" + numArray[i]);
            int tmpNum = Integer.parseInt(tmp.toString());
            if (primeList.get(tmpNum)) list.add(tmp.toString());
            set.add(i);

            dfs(numArray, list, primeList, set, tmpNum);
            set.remove(i);
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("0101"));
    }
}
