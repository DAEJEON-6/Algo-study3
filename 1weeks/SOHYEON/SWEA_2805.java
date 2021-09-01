package algo.study.swea.d3;

import java.util.Scanner;

// SWEA 2805. 농작물 수확하기
public class SWEA_2805 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				char[] chary = new char[N];
				String s = sc.next();
				chary = s.toCharArray();
				for (int j = 0; j < N; j++) {
					farm[i][j] = chary[j] - '0';
				}
			}
			// 윗부분
			for (int i = 0; i <= N / 2; i++) {
				for (int j = 0; j < (N - (N - 1 - 2 * i)); j++) {
					sum += farm[i][N / 2 - i + j];
				}
			}
			// 아랫부분
			for(int i=N/2+1; i<N; i++) {
				for(int j=0; j<N-(2*(i-N/2)); j++) {
					sum += farm[i][i-N/2+j];
				}
			}
			System.out.printf("#%d %d%n", test_case, sum);
		}
		sc.close();
	}

}
