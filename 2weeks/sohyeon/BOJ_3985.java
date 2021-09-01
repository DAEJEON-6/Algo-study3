package algo.study.boj.bronze;

import java.util.Scanner;

// BOJ 3985. 롤 케이크
public class BOJ_3985 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt(); // 롤 케이크 길이
		int[] cake = new int[L]; // 롤 케이크
		int N = sc.nextInt(); // 방청객 수
		int[] P = new int[N]; // P번부터
		int[] K = new int[N]; // K번 조각
		int[] cnt = new int[N]; // 최종 받는 케이크
		int expect = 0;  // 기대했던 가장 많은 조각
		int result = 0;  // 받은 가장 많은 조각

		for (int i = 0; i < N; i++) {
			P[i] = sc.nextInt();
			K[i] = sc.nextInt();
			if (expect < K[i] - P[i]) {
				expect = K[i] - P[i];
			}
			for (int j = P[i] - 1; j <= K[i] - 1; j++) {  // 롤케이크 조각 1~L -> -1 유의
				if (cake[j] == 0) {
					cake[j] = i + 1;
					cnt[i]++;
				}
			}
		}
		// 가장 많은 조각 받을 것으로 기대하던 방청객
		for (int i = 0; i < N; i++) {
			if (expect == K[i] - P[i]) {
				System.out.println(i + 1);
				break; // 여러 명이면 작은 번호
			}
		}

		// 실제로 가장 많은 조각 받은 방청객
		for (int i = 0; i < N; i++) {
			if (result < cnt[i]) {
				result = cnt[i];
			}
		}
		for (int i = 0; i < N; i++) {
			if (result == cnt[i]) {
				System.out.println(i + 1);
				break; // 여러 명이면 작은 번호
			}
		}
		
		sc.close();
	}

}
