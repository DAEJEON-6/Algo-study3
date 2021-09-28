package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 17136. 색종이 붙이기
public class BOJ_17136 {

	static int[][] map;
	static int[] colorpaper = {0, 5, 5, 5, 5, 5};  // 각 index 크기의 색종이 개수 저장
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		map = new int[10][10];
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bruteforce(0,0,0); // [0][0] 부터 0장의 색종이로 시작
		if(ans==Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(ans);
	}
	public static void bruteforce(int x, int y, int cnt) {
		// 마지막 위치까지 탐색이 끝났다면
		if(x==9 && y==10) {
			ans = Math.min(ans, cnt);
			return;
		}
		// 현재 cnt가 ans이상이면 더 이상 진행할 필요 없다. 가지치기!
		if(cnt >= ans) return;
		
		// 열을 끝까지 탐색했다면 그 다음 줄
		if(y > 9) {
			bruteforce(x+1, 0, cnt);
			return;
		}
		
		// 색종이를 붙여야 하는 칸이라면
		if(map[x][y]==1) {
			for(int i=5; i>=1; i--) {
				// 5~1 크기의 종이가 남아있고, 그 종이를 여기에 붙일 수 있는가?
				if(colorpaper[i]>0 && available(x,y,i)) {
					colorpaper[i]--;  // i크기의 색종이 한 장을 사용
					paperornot(x, y, i, 0);  // 색종이 붙이기
					bruteforce(x, y+1, cnt+1);
					paperornot(x, y, i, 1);  // 색종이 떼기
					colorpaper[i]++;  // i크기의 색종이 한 장 사용하지 않는다. 
				}
			}
		}else {
			bruteforce(x,y+1,cnt);
		}
	}
	// size 크기의 색종이를 붙일 수 있다면 true, 아니면 false 반환
	public static boolean available(int x, int y, int size) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				// 전체 크기를 넘어가거나
				if(i>=10 || j>=10) return false;
				// 색종이를 붙일 수 있는 곳이 아니라면 false
				if(map[i][j]!=1) return false;
			}
		}
		// 여기까지 왔다는 건 size 크기의 색종이를 붙일 수 있다는 것.
		return true;
	}
	// status(0이면 색종이 떼기, 1이면 색종이 붙이기)값으로 map 상태 설정
	public static void paperornot(int x, int y, int size, int status) {
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				map[i][j]=status;
			}
		}
	}
}
