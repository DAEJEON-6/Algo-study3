package algo.study.swea.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SWEA D3 4615. 재미있는 오셀로 게임
public class SWEA_4615 {
	
	static int[][] board;
	static int N, M;
	static int[][] deltas= {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};  // 8방 탐색
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());  // 보드 한변 길이 N
			M = Integer.parseInt(st.nextToken());  // 돌을 놓는 횟수 M
			board = new int[N][N];
			board[N/2-1][N/2-1]=2;
			board[N/2-1][N/2]=1;
			board[N/2][N/2-1]=1;
			board[N/2][N/2]=2;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken())-1;  // 돌 놓는 x위치
				int y = Integer.parseInt(st.nextToken())-1;  // 돌 놓는 y위치
				int color = Integer.parseInt(st.nextToken());  // 흑돌:1, 백돌:2
				
				board[x][y] = color;
				othello(x,y,color);
			}
			int black=0, white=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(board[i][j]==1) black++;
					else if(board[i][j]==2) white++;
				}
			}
			System.out.printf("#%d %d %d%n", test_case, black, white);
		}
	}
	
	public static void othello(int x, int y, int color) {
		for(int i=0; i<8; i++) {
			int dr = x + deltas[i][0];
			int dc = y + deltas[i][1];
			boolean check=false;  // board[dr][dc]가 자신의 돌인지 체크
			while(dr>=0 && dr<N && dc>=0 && dc<N && board[dr][dc]!=0) {
				if(board[dr][dc]==color) {  // board[dr][dc]가 같은 색 돌이라면 
					check=true;
					break;
				}
				// 다른 색이라면 같은 색 나올 때까지 탐색
				dr += deltas[i][0];
				dc += deltas[i][1];
			}
			while(check) {
				if(dr == x && dc == y) break;
				board[dr][dc] = color; // 상대 돌 색 나와 같은 색으로 교체
				dr -= deltas[i][0];
				dc -= deltas[i][1];
			}
		}
	}

}
