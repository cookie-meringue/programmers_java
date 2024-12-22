class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < sizes[i][1]) {
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
        }

        // sizes[i][0] 중 최댓값
        int maxW = getMaxValue(sizes, 0);

        // sizes[i][1] 중 최댓값
        int maxH = getMaxValue(sizes, 1);

        return maxW * maxH;
    }

    private int getMaxValue(int[][] sizes, int index) {
        int max = sizes[0][index];

        for (int i = 1; i < sizes.length; i++) {
            if (max < sizes[i][index]) {
                max = sizes[i][index];
            }
        }

        return max;
    }
}