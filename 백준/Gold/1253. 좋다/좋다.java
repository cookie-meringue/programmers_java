import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] arr = new long[n];
        IntStream.range(0, n).forEach(i -> arr[i] = scanner.nextLong());

        if (isAllZero(arr)) {
            System.out.println(n);
            return;
        }

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int start = 0;
            int end = n - 1;
            while (start < end) {
                if(start == i){
                    start++;
                    continue;
                } else if(end == i){
                    end--;
                    continue;
                }
                long sum = arr[start] + arr[end];

                if (sum == arr[i]) {
                    count++;
                    break;
                } else if (sum > arr[i]) {
                    end --;
                } else {
                    start ++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean isAllZero(long[] arr) {
        return Arrays.stream(arr).allMatch(n -> n == 0);
    }
}