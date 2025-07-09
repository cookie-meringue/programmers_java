import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        char[][] chessMap = new char[n][m];

        for (int i = 0; i < n; i++) {
            chessMap[i] = br.readLine().toCharArray();
        }

        int min = 32;
        for (int i = 0; i < n - 8 + 1; i++) {
            for (int j = 0; j < m - 8 + 1; j++) {
                int count = getCount(chessMap, i, j);
                if (count < min) {
                    min = count;
                }
            }
        }

        System.out.println(min);
    }

    private static int getCount(char[][] chessMap, int startI, int startJ) {
        int countStartWithB = 0;
        int countStartWithW = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expectedColorB = ((i + j) % 2 == 0) ? 'B' : 'W';
                char expectedColorW = ((i + j) % 2 == 0) ? 'W' : 'B';

                if (chessMap[startI + i][startJ + j] != expectedColorB) {
                    countStartWithB++;
                }
                if (chessMap[startI + i][startJ + j] != expectedColorW) {
                    countStartWithW++;
                }
            }
        }

        return Math.min(countStartWithB, countStartWithW);
    }
}
