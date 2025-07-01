import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>(9);
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int number = scanner.nextInt();
            sum += number;
            numbers.add(i, number);
        }

        List<Integer> result = new LinkedList<>();

        // 전부 다 더하고 완탐으로 두 개 뺀 게 100이면 출력
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int tempSum = numbers.get(i) + numbers.get(j);
                if (sum - tempSum == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            result.add(numbers.get(k));
                        }
                    }
                    break;
                }
            }
            if (!result.isEmpty()) {
                break;
            }
        }

        result.sort(Integer::compareTo);
        for (int i = 0; i < 7; i++) {
            System.out.println(result.get(i));
        }
    }
}
