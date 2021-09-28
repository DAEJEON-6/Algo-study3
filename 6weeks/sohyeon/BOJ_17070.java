package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 17070. 파이프 옮기기1
public class BOJ_17070 {

	static int n;
	static int[][][] dp;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		n = Integer.parseInt(br.readLine());
		map=new int[n][n];
		dp = new int[n][n][3];  // 1:가로 2:대각선 3:세로
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][1][0] = 1;  // 0,1 칸에 가로파이프의 끝이 있다.
		System.out.println(dp());
	}
	public static int dp() {
		for(int i=0; i<n; i++) {
			for(int j=2; j<n; j++) {  // 파이프는 항상 2열부터 놓을 수 있다.
				// 길이 막혀있으면 continue
				if(map[i][j]==1) continue;
				dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][1];  // 가로방향 파이프의 끝이 (i,j)인 경우
				if(i==0) continue;  // 맨 윗줄
				dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];  // 세로방향 파이프의 끝이 (i,j)인 경우
				if(map[i-1][j]==1 || map[i][j-1]==1) continue;  // (i,j) 기준 왼쪽, 위쪽이 막혀있으면 continue
				dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];  // 대각선 방향 파이프의 끝이 (,j)인 경우
			}
			
		}
		return dp[n-1][n-1][0] + dp[n-1][n-1][1] + dp[n-1][n-1][2];
	}

}
