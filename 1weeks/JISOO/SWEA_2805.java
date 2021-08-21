package com.ssafy.level3;

import java.util.Scanner;

public class SWEA_2805 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		int[][]map;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt(); //농장의 크기
			int value = 0;
			int ind = N;
			map = new int[N][N];
			
			for(int i=0; i<N; i++) { //농작물 가치 저장
				String str = sc.next();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j)-'0';
					value = value+map[i][j];
				}
			}
	
			for(int i=0; i<N/2; i++) { //위쪽 삼각형 농작물 수확
				for(int j=0; j<ind/2; j++) { //마름모 좌측 공간은 가치 창출x
					value = value-map[i][j];
				}						
				for(int j=0; j<ind/2; j++) { //마름모 우측 공간은 가치 창출x
					value = value-map[i][N-1-j];
				}
				ind = ind - 2;
			}
			
			ind = N;
			for(int i=N-1; i>N/2; i--) { //아래쪽 삼각형 농작물 수확
				for(int j=0; j<ind/2; j++) { //마름모 좌측 공간은 가치 창출x
					value = value-map[i][j];
				}
				for(int j=0; j<ind/2; j++) { //마름모 우측 공간은 가치 창출x
					value = value-map[i][N-1-j];
				}
				ind = ind - 2;
			}
			System.out.printf("#%d %d", test_case, value);
		}
	}
}
