package algo.study.jungol;

import java.util.Scanner;

// JUNGOL 1707. 달팽이 사각형
public class JUNGOL_1707 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] snail = new int[N][N];
		int[][] isCheck = new int[N][N];
		int x = 0, y = 0;
		int dir = 0;

		// 배열 원소 개수 만큼
		for (int i = 0; i < N * N; i++) {

			switch (dir) {
			case 0: // 우
				// x 고정, y++
				snail[x][y] = i + 1;
				isCheck[x][y] = 1;
				y = y + 1;
				// 벽에 부딪히거나 이미 간 곳이면
				if (y >= N || isCheck[x][y] == 1) {
					dir = 1; // 아래쪽방향으로 전환
					y--;
					x++;
				}
				break;
			case 1: // 하
				// x++, y 고정
				snail[x][y] = i + 1;
				isCheck[x][y] = 1;
				x = x + 1;
				// 벽에 부딪히거나 이미 간 곳이면
				if (x >= N || isCheck[x][y] == 1) {
					dir = 2; // 왼쪽방향으로 전환
					x--;
					y--;
				}
				break;
			case 2: // 좌
				// x 고정, y--
				snail[x][y] = i + 1;
				isCheck[x][y] = 1;
				y = y - 1;
				// 벽에 부딪히거나 이미 간 곳이면
				if (y < 0 || isCheck[x][y] == 1) {
					dir = 3; // 위쪽방향으로 전환
					y++;
					x--;
				}
				break;
			case 3: // 상
				// x--, y 고정
				snail[x][y] = i + 1;
				isCheck[x][y] = 1;
				x = x - 1;
				// 벽에 부딪히거나 이미 간 곳이면
				if (x < 0 || isCheck[x][y] == 1) {
					dir = 0; // 오른쪽방향으로 전환
					x++;
					y++;
				}
				break;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(snail[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}