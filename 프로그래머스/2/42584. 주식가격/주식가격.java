class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            for (int j = i + 1; j < prices.length; j++) {
                count++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
            if (i == prices.length - 1) {
                answer[i] = 0;
            } else {
                answer[i] = count;
            }
        }
        return answer;
    }
}