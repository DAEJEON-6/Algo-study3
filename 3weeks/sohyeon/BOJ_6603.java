package algo.study.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// BOJ 6603. 로또
public class BOJ_6603 {

	static int N,R=6;
	static int[] lotto;
	static int[] result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		while(Integer.parseInt(str[0]) != 0) {
			N = Integer.parseInt(str[0]);
			lotto = new int[N];
			result = new int[6];
			for(int i=0; i<lotto.length; i++) {
				lotto[i] = Integer.parseInt(str[i+1]);
			}
			combination(0,0);
			System.out.println();
			str = br.readLine().split(" ");
		}
		
		
	}
	// 조합 재귀
	public static void combination(int cnt, int start) {
		if(cnt == R) {
			print(result);
			return;
		}
		
		for(int i=start; i<N; i++) {	
			result[cnt] = lotto[i];	
			combination(cnt+1, i+1);
		}
	}
	
	public static void print(int[] number) {
		for(int i=0; i<number.length; i++) {
			System.out.print(number[i] + " ");
		}
		System.out.println();
	}

}
