package algo.study.boj.bronze;

import java.util.Scanner;

// BOJ 1592. 영식이와 친구들
public class BOJ_1592 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();  // 자리 수
		int M = sc.nextInt();  // 공 M번 -> 게임 끝
		int L = sc.nextInt();  // 나로부터 L번째

		int[] ballcatch = new int[N];
		int count = 0;

		for (int i = 0; i < N; i++) {
			ballcatch[i] = 0;
		}

		ballcatch[0] = 1;  // 공을 1번자리사람이 공을 받는다. 
		int i = 0;
		while (ballcatch[i] < M) {
			count++;
			if (ballcatch[i] % 2 == 1) { // 홀수 (시계)
				ballcatch[(i + L) % N]++;
				i = (i + L) % N;
			} else if (ballcatch[i] % 2 == 0) { // 짝수 (반시계)
				if (i - L >= 0) {
					ballcatch[(i - L) % N]++;
					i = (i - L) % N;
				} else {
					ballcatch[N - (Math.abs(i - L) % N)]++;
					i = N - (Math.abs(i - L) % N);
				}
			}
		}
		System.out.println(count);
		sc.close();
	}

}
