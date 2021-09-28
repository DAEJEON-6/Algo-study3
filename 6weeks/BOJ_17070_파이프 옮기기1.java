import java.util.Scanner;

public class BOJ_17070 {
	private static int count;
	private static int[][]map;
	private static int[][][]delta = { //가로, 세로, 대각선 이동 방향에 따른 파이프의 좌표 변화
			{{0,1},{1,1}},{{1,0},{1,1}},{{0,1},{1,0},{1,1}}
	};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int startR = 0; //파이프의 초기 위치 (오른쪽 값)
		int startC = 1;
		dfs(startR, startC, 0, N);
		System.out.println(count);
	}
	
	private static void dfs(int r, int c, int dir, int n) {
		if(r==n-1 && c==n-1) {
			count++;
			return;
		}
		
		for(int i=0; i<delta[dir].length; i++) {
			int nr = r+delta[dir][i][0];
			int nc = c+delta[dir][i][1];
			if(nr>=0 && nr<n && nc>=0 && nc<n && map[nr][nc]!=1) {
				int nxtDir = calcDirection(i,dir);
				
				if(nxtDir == 2) { //대각선으로 이동할 경우 빈 칸이어야 하는 곳이 추가됨
					if(!(map[nr][nc-1]!=1 && map[nr-1][nc]!=1)) {
						continue;
					}
				}
				
				dfs(nr, nc, nxtDir ,n);
			}
		}
	}

	private static int calcDirection(int i, int dir) { //이동 후 바뀌는 파이프의 방향 (0:가로, 1:세로, 2:대각선)
		if(i==delta[dir].length-1) {
			dir = 2;
		}else if(i==0 && dir==2) {
			dir = 0;
		}else if(i==1 && dir==2) {
			dir = 1;
		}
		return dir;		
	}
}