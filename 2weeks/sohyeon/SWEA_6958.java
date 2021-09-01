package algo.study.swea.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

// SWEA D3 6958. 동철이의 프로그래밍 대회
public class SWEA_6958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int N, M, sum = 0;
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case + " ");
			String[] str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]); // 사람 N명
			M = Integer.parseInt(str[1]); // 문제 M개
			int[][] problem = new int[N][M];
			int[] solved = new int[N];
			for (int i = 0; i < N; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < str.length; j++) {
					problem[i][j] = Integer.parseInt(str[j]);
				}
			}
			// 각 사람의 맞춘 문제 수 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (problem[i][j] == 1) {
						sum += 1;
					}
				}
				solved[i] = sum;
				sum=0;
			}

			Arrays.sort(solved);

			int max = solved[solved.length-1];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (max == solved[i]) {  // 1등한 사람 수 cnt
					cnt++;
				}
			}
			sb.append(cnt + " " + max +"\n");
		}
		System.out.println(sb);
	}

}
