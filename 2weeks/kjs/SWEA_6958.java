package com.ssafy.level3;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_6958 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer>winner = new ArrayList<>();
		
		int T = sc.nextInt();
		for(int i=1; i<=T; i++) {
			int N = sc.nextInt(); //사람 수
			int M = sc.nextInt(); //문제 수
			int curMax = 0; //현재까지 1등이 푼 문제수
			
			for(int j=0; j<N; j++) { //각 참가자들 마다
				int count = 0; //맞춘 문제수
				for(int k=0; k<M; k++) {
					if(sc.nextInt()==1) {
						count++;
					}
				}
				if(count > curMax) { //1등이 바뀜
					winner.clear();
					winner.add(j);
					curMax = count;
				}else if(count == curMax) { //1등과 점수가 같은 사람이 추가됨
					winner.add(j);
				}
			}
			System.out.printf("#%d %d %d%n", i,winner.size(),curMax);
			winner.clear(); //테케마다 조기화
		}
	}

}
