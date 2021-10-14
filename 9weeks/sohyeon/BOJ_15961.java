package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BOJ 15961. 회전초밥 (슬라이딩 윈도우 알고리즘 이용)
public class BOJ_15961 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //접시의 수
		int D = Integer.parseInt(st.nextToken()); // 초밥종류
		int K = Integer.parseInt(st.nextToken()); // 연속 접시 수
		int C = Integer.parseInt(st.nextToken()); // 쿠폰번호
		
		int[] sushi = new int[D+1];
		int[] rotateTable = new int[N];
		sushi[C] = 1;
		for (int i = 0; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			rotateTable[i] = number;
		}
		
		int count = 1;
		int start=0,end=K-1;
		for (int i=0; i<K; i++) {
			if(sushi[rotateTable[i]]++==0) count++;
		}
		int answer = count;
		
		while(start<N-1) {
			if(sushi[rotateTable[start++]]--==1) count--;
			end = (end+1)%N;
			if(sushi[rotateTable[end]]++==0) count++;
			
			answer = answer < count ? count : answer;
		}
		
		System.out.println(answer);
	}

}