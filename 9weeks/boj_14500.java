import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [백준] 테트로미노
 *  출처 : https://www.acmicpc.net/problem/14500
 *  풀이 기법 : 구현
 */

public class Main {

	static int[][] O = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
	static int[][] I = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } };
	static int[][][] L = { { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 } },
			{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } }, { { 0, 2 }, { 1, 0 }, { 1, 1 }, { 1, 2 } } };
	static int[][][] Z = { { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } }, { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 2, 0 } } };
	static int[][][] T = { { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } }, { { 0, 1 }, { 1, 0 }, { 1, 1 }, { 2, 1 } } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] paper = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		// O검사
		out: for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if (x + 1 >= M)
					continue;
				if (y + 1 >= N)
					break out;

				int sum = 0;
				for (int i = 0; i < 4; i++) {
					sum += paper[y + O[i][0]][x + O[i][1]];
				}

				result = Math.max(sum, result);
			}
		}

		// I 세로검사
		out: for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (y + 3 >= N)
					break out;

				int sum = 0;
				for (int i = 0; i < 4; i++) {
					sum += paper[y + I[i][1]][x + I[i][0]];
				}

				result = Math.max(sum, result);
			}
		}
		// I가로 검사
		out: for (int y = 0; y < N; y++) {
			for (int x = 0; x <M; x++) {
				if (x + 3 >= M)
					continue out;

				int sum = 0;
				for (int i = 0; i < 4; i++) {
					sum += paper[y + I[i][0]][x + I[i][1]];
				}

				result = Math.max(sum, result);
			}
		}

		// L 서있는거 검사
		out: for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (x + 1 >= M)
					continue;
				if (y + 2 >= N)
					break out;

				int[] sum = { 0, 0, 0, 0 };

				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (i % 2 == 0) {
							sum[i] += paper[y + L[i][j][0]][x + L[i][j][1]];
						} else {
							sum[i] += paper[y + L[i][j][1]][x + L[i][j][0]];
						}
					}
				}

				for (int i = 0; i < 4; i++) {
					result = Math.max(result, sum[i]);
				}
			}
		}

		// L 누워있는거 검사
		out: for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (x + 2 >= M)
					continue;
				if (y + 1 >= N)
					break out;

				int[] sum = { 0, 0, 0, 0 };

				for (int i = 0; i < 4; i++) {
					for (int j = 0; j < 4; j++) {
						if (i % 2 != 0) {
							sum[i] += paper[y + L[i][j][0]][x + L[i][j][1]];
						} else {
							sum[i] += paper[y + L[i][j][1]][x + L[i][j][0]];
						}
					}
				}

				for (int i = 0; i < 4; i++) {
					result = Math.max(result, sum[i]);
				}
			}
		}

		// Z검사
		out: for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (x + 1 >= M)
					continue;
				if (y + 2 >= N)
					break out;

				int[] sum = { 0, 0 };

				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 4; j++) {
						sum[i] += paper[y + Z[i][j][0]][x + Z[i][j][1]];
					}
				}

				for (int i = 0; i < 2; i++) {
					result = Math.max(result, sum[i]);
				}
			}
		}
		// Z누워있는거
		out: for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (x + 2 >= M)
					continue;
				if (y + 1 >= N)
					break out;

				int[] sum = { 0, 0 };

				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 4; j++) {
						sum[i] += paper[y + Z[i][j][1]][x + Z[i][j][0]];
					}
				}

				for (int i = 0; i < 2; i++) {
					result = Math.max(result, sum[i]);
				}
			}
		}

		// T검사
		out: for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (x + 2 >= M)
					continue;
				if (y + 1 >= N)
					break out;

				int[] sum = { 0, 0 };

				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 4; j++) {
						if (i % 2 == 0) {
							sum[i] += paper[y + T[i][j][0]][x + T[i][j][1]];
						} else {
							sum[i] += paper[y + T[i][j][1]][x + T[i][j][0]];
						}
					}
				}

				for (int i = 0; i < 2; i++) {
					result = Math.max(result, sum[i]);
				}
			}
		}

		// T검사 슨거
		out: for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (x + 1 >= M)
					continue;
				if (y + 2 >= N)
					break out;

				int[] sum = { 0, 0 };

				for (int i = 0; i < 2; i++) {
					for (int j = 0; j < 4; j++) {
						if (i % 2 == 1) {
							sum[i] += paper[y + T[i][j][0]][x + T[i][j][1]];
						} else {
							sum[i] += paper[y + T[i][j][1]][x + T[i][j][0]];
						}
					}
				}

				for (int i = 0; i < 2; i++) {
					result = Math.max(result, sum[i]);
				}
			}
		}
		
		System.out.println(result);

	}
}
