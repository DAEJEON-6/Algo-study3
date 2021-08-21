package com.ssafy.level3;

import java.util.Scanner;

public class SWEA_6730 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[]map; //블록의 높이 저장

		for(int i=1; i<=T; i++) {
			int N = sc.nextInt();
			map = new int[N];
			int up = 0, down = 0; //가장 심한 높이변화
			
			for(int j=0; j<N; j++) { //각 블록의 높이 저장
				map[j] = sc.nextInt();
			}

			for(int j=0; j<map.length-1; j++) {
				if(map[j] < map[j+1]) { //뒤에 오는 수가 더 클 경우, 올라갈 때 최대변화 갱신
					up = Math.max(up, map[j+1]-map[j]);
				}else if(map[j] > map[j+1]){ //뒤에 오는 수가 더 작은 경우, 내려갈 때 최대변화 갱신
					down = Math.max(down, map[j]-map[j+1]);
				}
			}
			System.out.printf("#%d %d %d%n", i, up, down);
		}
	}
}
