import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] input = new String[3];

        for (int i = 0; i < 3; i++) {
            input[i] = scanner.nextLine();
        }

        String answer = "";

        for (int i = 0; i < 3; i++) {
            try {
                int n = Integer.parseInt(input[i]);
                int answerNumber = n + (3 - i);
                if (isFizz(answerNumber)) {
                    answer = "Fizz";
                } else if (isBuzz(answerNumber)) {
                    answer = "Buzz";
                } else if (isFizzBuzz(answerNumber)) {
                    answer = "FizzBuzz";
                } else {
                    answer = String.valueOf(n + (3 - i));
                }
            } catch (NumberFormatException ignored) {

            }
        }
        System.out.println(answer);
    }

    private static boolean isFizzBuzz(int number) {
        return number % 15 == 0;
    }

    private static boolean isFizz(int number) {
        return number % 3 == 0 && number % 5 != 0;
    }

    private static boolean isBuzz(int number) {
        return number % 5 == 0 && number % 3 != 0;
    }
}
