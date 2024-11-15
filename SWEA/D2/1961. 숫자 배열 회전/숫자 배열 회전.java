/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;

class Solution{
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int[][] result = new int[n][3*n];
			int resultYIndex = 0;
			
			// 입력 받기
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			// 90 도 먼저 출력
			int resultI = 0;
			for(int j = 0; j<n; j++) {
				for(int i = n-1; i>=0; i--) {
					result[resultI][resultYIndex++] = arr[i][j];
				}
				resultYIndex = 0;
				resultI++;
			}
			
			resultYIndex = n;
			
			// 180 도
			resultI = 0;
			for(int i = n-1; i>=0; i--) {
				for(int j = n-1; j>=0; j--) {
					result[resultI][resultYIndex++] = arr[i][j];
				}
				resultYIndex = n;
				resultI++;
			}
			
			resultYIndex = 2*n;
			
			// 270 도
			resultI = 0;
			for(int j = n-1; j>=0; j--) {
				for(int i = 0; i<n; i++) {
					result[resultI][resultYIndex++] = arr[i][j];
				}
				resultYIndex = 2*n;
				resultI++;
			}
			System.out.println("#" + test_case);
			for(int i = 0; i<n; i++) {
				for(int j = 0; j<n; j++) {
					System.out.print(result[i][j]);
				}
				System.out.print(" ");
				for(int j = n; j<2*n; j++) {
					System.out.print(result[i][j]);
				}
				System.out.print(" ");
				for(int j = 2*n; j<3*n; j++) {
					System.out.print(result[i][j]);
				}
				System.out.println();
			}
		}
	}
}