import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scanner.nextLine());
        char[][] arr = inputArr(n);

        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < n - 1) {
                    max = Math.max(max, getMaxCount(getSwitchedArr(arr, n, i, j, i + 1, j), n, i, j));
                }
                if (i > 0) {
                    max = Math.max(max, getMaxCount(getSwitchedArr(arr, n, i, j, i - 1, j), n, i, j));
                }
                if (j > 0) {
                    max = Math.max(max, getMaxCount(getSwitchedArr(arr, n, i, j, i, j - 1), n, i, j));
                }
                if (j < n - 1) {
                    max = Math.max(max, getMaxCount(getSwitchedArr(arr, n, i, j, i, j + 1), n, i, j));
                }
            }
        }

        System.out.println(max);
    }

    public static int getMaxCount(char[][] arr, int n, int i, int j) {
        int max = 1;

        int maxHorizontalCount = getMaxHorizontalCount(arr, n, i);
        int maxVerticalCount = getMaxVerticalCount(arr, n, j);
//        int maxDiagonalCount = getMaxDiagonalCount(arr, n, i, j);

        max = Math.max(max, maxHorizontalCount);
        max = Math.max(max, maxVerticalCount);
//        max = Math.max(max, maxDiagonalCount);

        return max;
    }

    public static char[][] getSwitchedArr(char[][] arr, int n, int fromX, int fromY, int toX, int toY) {
        char[][] result = new char[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, result[i], 0, n);
        }

        char temp = result[fromX][fromY];
        result[fromX][fromY] = result[toX][toY];
        result[toX][toY] = temp;

        return result;
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

    public static int getMaxHorizontalCount(char[][] arr, int n, int nowY) {
        int max = 1;
        int count = 1;

        for (int x = 0; x < n - 1; x++) {
            if (arr[nowY][x] != arr[nowY][x + 1]) {
                if (count > max) {
                    max = count;
                }
                count = 1;
                continue;
            }
            count++;
        }

        if (count > max) {
            max = count;
        }

        return max;
    }

    public static int getMaxVerticalCount(char[][] arr, int n, int nowY) {
        int max = 1;
        int count = 1;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i][nowY] != arr[i + 1][nowY]) {
                if (count > max) {
                    max = count;
                }
                count = 1;
                continue;
            }
            count++;
        }

        if (count > max) {
            max = count;
        }

        return max;
    }

    public static int getMaxDiagonalCount(char[][] arr, int n, int nowX, int nowY) {
        int max = 1;
        int count = 1;

        // 기울기가 양수인 경우
        int x, y;

        y = Math.min(nowY + nowX, (n - 1));
        x = nowX - Math.abs(y - nowY);

        while (y > 0 && x < n - 1) {
            if (arr[y][x] != arr[y - 1][x + 1]) {
                if (count > max) {
                    max = count;
                }
                count = 1;
                x++;
                y--;
                continue;
            }
            count++;
            x++;
            y--;
        }

        if (count > max) {
            max = count;
        }

        // 기울기가 음수인 경우
        count = 1;
        y = Math.max(nowY - nowX, 0);
        x = nowX - Math.abs(y - nowY);

        while (y < n - 1 && x < n - 1) {
            if (arr[y][x] != arr[y + 1][x + 1]) {
                if (count > max) {
                    max = count;
                }
                count = 1;
                x++;
                y++;
                continue;
            }
            count++;
            x++;
            y++;
        }

        if (count > max) {
            max = count;
        }

        return max;
    }
}
