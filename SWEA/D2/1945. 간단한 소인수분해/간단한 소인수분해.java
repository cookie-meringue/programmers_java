
import java.util.Scanner;

class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

		for(int test_case = 1; test_case <= T; test_case++){
			int n = sc.nextInt();
			
			int[] result = new int[5];
			
			while(n % 2 == 0) {
				result[0]++;
				n /= 2;
			}
			
			while(n % 3 == 0) {
				result[1]++;
				n /= 3;
			}
			
			while(n % 5 == 0) {
				result[2]++;
				n /= 5;
			}
			
			while(n % 7 == 0) {
				result[3]++;
				n /= 7;
			}
			
			while(n % 11 == 0) {
				result[4]++;
				n /= 11;
			}
			
			System.out.print("#"+test_case + " ");
			for(int i = 0; i<5; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println();
		}
	}
}
