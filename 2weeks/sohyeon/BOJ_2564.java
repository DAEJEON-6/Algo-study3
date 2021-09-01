package algo.study.boj.silver;

import java.util.Scanner;

// BOJ 2564. 경비원
public class BOJ_2564 {

	static int R,C,N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt();  // 행
		R = sc.nextInt();  // 열
		N = sc.nextInt();  // 상점 개수
		int round = 2*R + 2*C;
		int[][] store = new int[N][2];
		int[] clockwisedis = new int[N];
		int result = 0;
		for(int i=0; i<N; i++) {
			store[i][0] = sc.nextInt();  // 방향
			store[i][1] = sc.nextInt();  // 거리
		}
		int[] dong = new int[2];  // 동근이
		dong[0] = sc.nextInt();  // 방향 
		dong[1] = sc.nextInt();  // 거리
	
		// 상점들의 시계방향 거리
		for(int i=0; i<N; i++) {
			clockwisedis[i] = clockwise(store[i][0], store[i][1]);
		}
		for(int i=0; i<N; i++) {
			int clockwise = Math.abs(clockwise(dong[0],dong[1]) - clockwisedis[i]);
			result += Math.min(clockwise, round - clockwise);
		}
		System.out.println(result);
		sc.close();
	}

	public static int clockwise(int dir, int dis) {
		int distance = 0;
		if(dir==1) {  // 북
			distance = dis;
		}else if(dir==2) {  // 남
			distance = C + R + (C-dis);
		}else if(dir==3) {  // 서
			distance = C + R + C + (R-dis);
		}else if(dir==4) {  // 동
			distance = C + dis;
		}
		return distance;
	}
}
