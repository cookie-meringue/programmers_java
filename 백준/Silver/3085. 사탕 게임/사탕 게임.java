import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        char[][] arr = inputArr(n);

        int max = getMaxCount(arr, n); // 초기 상태에서도 최댓값일 수 있음

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 오른쪽 교환
                if (j + 1 < n && arr[i][j] != arr[i][j + 1]) {
                    swap(arr, i, j, i, j + 1);
                    max = Math.max(max, getMaxCount(arr, n));
                    swap(arr, i, j, i, j + 1); // 원복
                }

                // 아래쪽 교환
                if (i + 1 < n && arr[i][j] != arr[i + 1][j]) {
                    swap(arr, i, j, i + 1, j);
                    max = Math.max(max, getMaxCount(arr, n));
                    swap(arr, i, j, i + 1, j); // 원복
                }
            }
        }

        System.out.println(max);
    }

    private static void swap(char[][] arr, int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    public static int getMaxCount(char[][] arr, int n) {
        int max = 1;

        for (int i = 0; i < n; i++) {
            int rowCount = 1;
            int colCount = 1;

            for (int j = 1; j < n; j++) {
                // 행 검사
                if (arr[i][j] == arr[i][j - 1]) {
                    rowCount++;
                } else {
                    rowCount = 1;
                }
                max = Math.max(max, rowCount);

                // 열 검사
                if (arr[j][i] == arr[j - 1][i]) {
                    colCount++;
                } else {
                    colCount = 1;
                }
                max = Math.max(max, colCount);
            }
        }

        return max;
    }

    public static char[][] inputArr(int n) {
        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j);
            }
        }
        return arr;
    }
}