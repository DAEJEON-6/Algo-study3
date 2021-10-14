package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 14500. 테트로미노
public class BOJ_14500 {

	static int N; // 종이의 세로 크기 N행
	static int M; // 종이의 가로 크기 M열
	static int[][] paper;
	static boolean[][] visited;
	static int result = 0;
	static int[][] deltas1 = { { 0,-1 }, { 0,1 }, { -1,0 }, { 1,0 } };
	// ㅜ일 때 모든 경우(ㅜ,ㅗ,ㅓ,ㅏ순)
	static int[][][] deltas2 = { { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } }, { { 1, 0 }, { 1, 1 }, { 1, 2 }, { 0, 1 } },
			{ { 0, 1 }, { 1, 1 }, { 2, 1 }, { 1, 0 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 1, 1 } } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// ㅜ를 제외한 4가지는 depth가 4인 dfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				// 4가지
				visited[i][j] = true;
				dfs(i, j, paper[i][j], 1);
				visited[i][j] = false;

				// ㅜ모양
				addtioncalCase(i, j);
			}
		}
		System.out.println(result);
	}

	// ㅜ를 제외한 4가지 경우(dfs를 이용하여 모든 경우 가능)
	private static void dfs(int x, int y, int sum, int depth) {
		if (depth >= 4) {
			result = Math.max(result, sum);
			return;
		} else {
			for (int i = 0; i < 4; i++) {
				int nx = x + deltas1[i][0];
				int ny = y + deltas1[i][1];
				// 종이 범위 넘어가는지 확인
				if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
				// 방문한적 없으면
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx, ny, (sum+paper[nx][ny]), depth+1);
					// 체크 해제
					visited[nx][ny] = false;
				}
			}
		}
	}

	// ㅜ,ㅗ,ㅓ,ㅏ 모양 검사
	private static void addtioncalCase(int x, int y) {
		boolean outCheck = false;

		for (int i = 0; i < 4; i++) {
			int sum = 0;
			outCheck = false;
			for (int j = 0; j < 4; j++) {
				int nx = x + deltas2[i][j][0]; // 세로
				int ny = y + deltas2[i][j][1]; // 가로

				// 종이 범위 넘어가는지 체크
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					outCheck = true;
					continue;
				}
				sum += paper[nx][ny];
			}

			// 범위 안나갔으면
			if (!outCheck)
				result = Math.max(sum, result);
		}

	}
}
