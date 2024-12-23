import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n == 1) {
            System.out.println(0);
            return;
        }
        int[] primes = getPrimes(n);

        int startIndex = 0;
        int endIndex = 0;
        int sum = primes[0];
        int count = 0;

        while (endIndex != primes.length) {
            if (sum == n) {
                count++;
                sum -= primes[startIndex];
                startIndex++;
            } else if (sum > n) {
                sum -= primes[startIndex];
                startIndex++;
            } else {
                endIndex++;
                if (endIndex < primes.length) {
                    sum += primes[endIndex];
                }
            }
        }

        System.out.println(count);
    }


    private static int[] getPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes.stream().mapToInt(i -> i).toArray();
    }
}