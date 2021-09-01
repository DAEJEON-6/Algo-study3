package algo.study.boj.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 2798. 블랙잭
public class BOJ_2798 {

	static int N,R=3,M;
	static int[] cards;
	static int[] result;
	static int ans=-1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());  // 카드 개수 N개
		M = Integer.parseInt(st.nextToken());  // M을 넘지 않으면서 M에 최대한 가까운 카드 찾기
		cards = new int[N];
		result = new int[3];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cards);
		combination(0,0);
		System.out.println(ans);
	}
	public static void combination(int cnt, int start) {
		if(cnt==R) {
			int sum=0;
			for(int i=0; i<R; i++) {
				sum+=result[i];
			}
			if(sum<=M) {
				if(M-ans > M-sum) {
					ans=sum;
				}
			}
			return;
		}
		for(int i=start; i<N; i++) {
			result[cnt] = cards[i];
			combination(cnt+1, i+1);
		}
	}
}
