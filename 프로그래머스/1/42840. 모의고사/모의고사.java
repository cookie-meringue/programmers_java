import java.util.LinkedList;
import java.util.List;

class Solution {

    private final int[] arr1 = {1, 2, 3, 4, 5};
    private final int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
    private final int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int index = 0;

        int count1 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (index == arr1.length) {
                index = 0;
            }
            count1 += arr1[index] == answers[i] ? 1 : 0;
            index++;
        }

        index = 0;
        int count2 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (index == arr2.length) {
                index = 0;
            }
            count2 += arr2[index] == answers[i] ? 1 : 0;
            index++;
        }

        index = 0;
        int count3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (index == arr3.length) {
                index = 0;
            }
            count3 += arr3[index] == answers[i] ? 1 : 0;
            index++;
        }

        List<Integer> answer = new LinkedList<>();

        int max = Math.max(Math.max(count1, count2), Math.max(count2, count3));

        if (count1 == max) {
            answer.add(1);
        }
        if (count2 == max) {
            answer.add(2);
        }
        if (count3 == max) {
            answer.add(3);
        }

        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }
}