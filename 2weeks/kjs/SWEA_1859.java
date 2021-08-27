package com.ssafy.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1859 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[]prices;

		for(int i=1; i<=T; i++) {
			long maxProfit = 0; //최대 이익
			int N = Integer.parseInt(br.readLine()); //요일 수
			prices = new int[N]; //요열별 매매가 저장
			int ind = 0;

			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				prices[ind] = Integer.parseInt(st.nextToken());
				ind++;
			}

			long curMax = prices[N-1]; //마지막날에 팔았을 경우를 최대이익으로 초기화

			for(int j=N-2; j>=0; j--) { //마지막부터 순회하면서, [i]에서 산 가격이 현재 최고가에서 팔 때보다 이익이면 산다
				if(prices[j] < curMax) { //지금 사서 나중에 있을 최고가에서 팔면 이득
					maxProfit += (curMax-prices[j]);
				}else if(prices[j] > curMax) { //뒤에 가격이 다 자신보다 낮기에 산다면 지금 산다면 손해
					curMax = prices[j];//현 가격을 최고가로 갱신
				}	
			}

			System.out.printf("#%d %d%n",i,maxProfit);
		}
	}

}
