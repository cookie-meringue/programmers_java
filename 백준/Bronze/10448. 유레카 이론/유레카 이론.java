import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int[] eurekaNumbers = new int[44];

    static {
        int number = 1;
        int increaseNum = 2;
        for (int i = 0; i < 44; i++) {
            eurekaNumbers[i] = number;
            number += increaseNum;
            increaseNum++;
        }
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            if (isSummable(arr[i])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    public static boolean isSummable(int number) {
        int sum;
        for (int i = 0; i < 42; i++) {
            sum = eurekaNumbers[i];
            for (int j = i; j < 43; j++) {
                sum += eurekaNumbers[j];
                for (int k = j; k < 42; k++) {
                    sum += eurekaNumbers[k];
                    if (sum == number) {
                        return true;
                    }
                    sum -= eurekaNumbers[k];
                }
                sum -= eurekaNumbers[j];
            }
        }

        return false;
    }
}
