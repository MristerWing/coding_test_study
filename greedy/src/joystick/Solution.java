package joystick;

public class Solution {
    public static int solution(String name) {
        int answer = 0;
        StringBuilder builder = new StringBuilder();
        char[] chars = name.toCharArray();
        char a = 'A';
        char z = 'Z';
        int index = 0;

        while (!name.equals(builder.toString())) {
            if (index < chars.length - 1 && chars[index] == 'A') {
                int indexCheck = index;
                int count = 0;
                while (chars[index] == 'A') {
                    if (index == chars.length - 1) break;
                    builder.append('A');
                    index++;
                    count++;
                }
                if (chars[index] == 'A') break;
                else if (count < indexCheck) {
                    answer += count;
                } else {
                    if (indexCheck == 0 && count <= chars.length - 1 / 2) answer += count;
                    else answer += indexCheck - 1;
                }
            } else {
                int minusA = Math.abs(chars[index] - a);
                int minusZ = Math.abs(chars[index] - z);

                if (minusA < minusZ + 1) {
                    answer += minusA;
                    builder.append((char) (a + minusA));
                } else {
                    answer += minusZ + 1;
                    builder.append((char) (z - minusZ));
                }
                index++;
                answer++;
            }
        }

        System.out.println(builder + " " + answer);

        // 0일경우 그냥 리턴
        return answer == 0 ? 0 : answer - 1;
    }

    public static void main(String[] args) {
        String name = "AAAAAAAA";
        System.out.println(solution(name));
    }
}
