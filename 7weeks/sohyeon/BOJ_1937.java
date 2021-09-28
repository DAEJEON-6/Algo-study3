package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 1937. 욕심쟁이 판다
public class BOJ_1937 {

	static int n;
	static int[][] forest;
	static int[][] move;
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상 우 하 좌
	static int result=Integer.MIN_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); // 대나무 숲의 크기
		forest = new int[n][n];
		move = new int[n][n];
		StringTokenizer st = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				forest[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				result = Math.max(dfs(i,j), result);
			}
		}
		// -> move배열에는 각 지점에서 최대 이동가능한 칸 수가 저장된다.
		System.out.println(result);
	}

	public static int dfs(int x, int y) {
		// 이미 계산이 끝난 곳이면 return
		if(move[x][y]!=0) return move[x][y];
		
		int length=1;
		for (int i = 0; i < 4; i++) {
			int dr = x + deltas[i][0];
			int dc = y + deltas[i][1];
			// 범위 밖이면 continue
			if (dr < 0 || dr >= n || dc < 0 || dc >= n )
				continue;
			// 자리 옮긴 지역의 대나무 양 > 옮기기 전 지역의 대나무 양
			if (forest[dr][dc] > forest[x][y]) {
				length = Math.max(length, dfs(dr, dc)+1);
				move[x][y] = length;
			}
		}
		return length;
	}

}
