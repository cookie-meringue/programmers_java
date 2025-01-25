import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }

        List<Integer> result = new LinkedList<>();

        int cnt = 1;
        while (!deque.isEmpty()) {

            if (cnt == k) {
                result.add(deque.removeFirst());
                cnt = 1;
                continue;
            }
            deque.addLast(deque.removeFirst());
            cnt++;
        }

        System.out.print("<");
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1) {
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i) + ", ");
            }
        }
        System.out.print(">");
    }
}