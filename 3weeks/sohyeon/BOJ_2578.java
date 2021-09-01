package algo.study.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 2578. 빙고
public class BOJ_2578 {

	static int[] cntX;
	static int[] cntY;
	static int[] cntCross;
	static int Bingo = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[][] bingo = new String[5][5]; // bingo 타입을 Integer로 하면 Arrays.asList(bingo[k]).indexof() 잘 수행된다.
		cntX = new int[5];
		cntY = new int[5];
		cntCross = new int[2]; // /, \ 방향 크로스
		int call = 0;

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				bingo[i][j] = st.nextToken();
			}
		}

		for1 :for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				String compare = st.nextToken();
				int y = -1;

				for (int k = 0; k < 5; k++) {
					ArrayList<String> tmp = new ArrayList<>(Arrays.asList(bingo[k]));
					y = tmp.indexOf(compare);
					if (y != -1) { // k 행에서 부른 수 발견
						call++; 
						setCntX(k);
						setCntY(y);
						if (k + y == 4)
							setCntCross(0);
						else if (k == y)
							setCntCross(1);
						break;
					}
				}
				if (Bingo >= 3) {
					System.out.println(call);
					break for1;
				}

			}
		}
	}
	// 행 빙고
	public static void setCntX(int x) {
		cntX[x]++;
		if (cntX[x] == 5)
			Bingo++;
	}
	// 열 빙고
	public static void setCntY(int y) {
		cntY[y]++;
		if (cntY[y] == 5)
			Bingo++;
	}
	// 대각선 빙고
	public static void setCntCross(int num) {
		cntCross[num] += 1;
		if (cntCross[num] == 5)
			Bingo++;
	}

}
