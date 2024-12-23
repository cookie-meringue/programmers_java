import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int nA = scanner.nextInt();
        int nB = scanner.nextInt();

        int[] arrA = new int[nA];
        int[] arrB = new int[nB];
        StringBuilder stringBuilder = new StringBuilder();

        IntStream.range(0, nA).forEach(i -> arrA[i] = scanner.nextInt());
        IntStream.range(0, nB).forEach(i -> arrB[i] = scanner.nextInt());

        int indexA = 0;
        int indexB = 0;

        for (int i = 0; i < nA + nB; i++) {
            if (indexA == nA) {
                stringBuilder.append(arrB[indexB]).append(" ");
                indexB++;
            } else if (indexB == nB) {
                stringBuilder.append(arrA[indexA]).append(" ");
                indexA++;
            } else {
                if (arrA[indexA] < arrB[indexB]) {
                    stringBuilder.append(arrA[indexA]).append(" ");
                    indexA++;
                } else {
                    stringBuilder.append(arrB[indexB]).append(" ");
                    indexB++;
                }
            }
        }

        System.out.println(stringBuilder);
    }
}