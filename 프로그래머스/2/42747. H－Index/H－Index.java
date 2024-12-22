import static java.util.Arrays.sort;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        sort(citations);
        int length = citations.length;

        for (int h = 0; h <= citations[length - 1]; h++) {
            int lastIndex = contains(citations, h) ? getLastIndex(h, citations) : getLastIndex(h, citations) + 1;
            if (h < citations[0]) {
                lastIndex = 0;
            }
            if (length - lastIndex >= h && lastIndex <= h) {
                answer = h;
            }
        }
        return answer;
    }

    private int getLastIndex(int number, int[] citations) {
        int result = 0;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] < number) {
                result = i;
                continue;
            }
            break;
        }
        return result;
    }

    private boolean contains(int[] citations, int number) {
        for (int citation : citations) {
            if (citation == number) {
                return true;
            }
        }
        return false;
    }
}