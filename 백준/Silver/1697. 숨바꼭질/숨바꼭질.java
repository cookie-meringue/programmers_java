import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int size = Math.max(a, b) + 2;
        map = new int[size];
        for (int i = 0; i < size; i++) {
            map[i] = -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{a, 0});
        map[a] = 0;
        while (!queue.isEmpty() && map[b] == -1) {
            int[] n = queue.poll();
            int num = n[0];
            int second = n[1] + 1;

            int numP = num + 1;
            if (numP >= 0 && numP < size) {
                if (map[numP] == -1 || map[numP] > second) {
                    map[numP] = second;
                    queue.add(new int[]{numP, second});
                }
            }

            int numM = num - 1;
            if (numM >= 0 && numM < size) {
                if (map[numM] == -1 || map[numM] > second) {
                    map[numM] = second;
                    queue.add(new int[]{numM, second});
                }
            }

            int numMM = num * 2;
            if (numMM >= 0 && numMM < size) {
                if (map[numMM] == -1 || map[numMM] > second) {
                    map[numMM] = second;
                    queue.add(new int[]{numMM, second});
                }
            }
        }
        System.out.println(map[b]);
    }
}
