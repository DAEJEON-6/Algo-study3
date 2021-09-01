package algo.study.boj.silver;

import java.util.Scanner;

// BOJ 10157. 자리배정
public class BOJ_10157 {

	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상(0), 우(1), 하(2), 좌(3)
	static int[][] sitnum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();  // 열
		int R = sc.nextInt();  // 행
		int K = sc.nextInt();  // 대기번호
		sitnum = new int[R][C];
		int num = R * C, i = 1;
		int x = R - 1, y = 0, dir = 0;
		sitnum[x][y] = i;
		// K가 1인 경우
		if (i == K)
			System.out.printf("%d %d", y + 1, R - x);
		else if (K > num)
			System.out.println("0");
		else {
			while (i++ < num) {
				int dr = x + deltas[dir][0];
				int dc = y + deltas[dir][1];
				switch (dir) {
				case 0:  // 상
					// 범위 밖 or 이미 배정받은 자리인지 체크
					if (dr < 0 || sitnum[dr][dc] != 0) {
						i--;
						dir = 1;
						dr -= deltas[dir][0];
					} else {
						// 배정위치 저장
						x = dr;
						y = dc;
						sitnum[x][y] = i;
					}
					break;
				case 1:  // 우
					if (dc >= C || sitnum[dr][dc] != 0) {
						i--;
						dir = 2;
						dc -= deltas[dir][1];
					} else {
						x = dr;
						y = dc;
						sitnum[x][y] = i;
					}
					break;
				case 2:  // 하
					if (dr >= R || sitnum[dr][dc] != 0) {
						i--;
						dir = 3;
						dr -= deltas[dir][0];
					} else {
						x = dr;
						y = dc;
						sitnum[x][y] = i;
					}
					break;
				case 3:  // 좌
					if (dc < 0 || sitnum[dr][dc] != 0) {
						i--;
						dir = 0;
						dc -= deltas[dir][1];
					} else {
						x = dr;
						y = dc;
						sitnum[x][y] = i;
					}
					break;
				}
				if (i == K) {
					System.out.printf("%d %d", y + 1, R - x);
					break;
				}
			}
		}
		sc.close();
	}
}
