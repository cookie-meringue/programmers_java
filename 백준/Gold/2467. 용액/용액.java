import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        IntStream.range(0, n).forEach(i -> arr[i] = scanner.nextInt());

        Arrays.sort(arr);
        int min = Math.abs(arr[0] + arr[arr.length - 1]);
        int minA = arr[0];
        int minB = arr[arr.length - 1];
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex < endIndex) {
            int sum = arr[startIndex] + arr[endIndex];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                minA = arr[startIndex];
                minB = arr[endIndex];
                if (sum == 0) {
                    break;
                }
            }

            if (sum < 0) {
                startIndex++;
            } else {
                endIndex--;
            }
        }

        System.out.println(minA + " " + minB);
    }
}