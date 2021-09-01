package algo.study.boj.bronze;

import java.util.Scanner;

// BOJ 8320. 직사각형을 만드는 방법
public class BOJ_8320 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int count=0;
		
		for(int i=1; i<=N; i++) {
			for(int j=i; j<=N; j++) {
				if(i*j<=N)count++;
			}
		}
		System.out.println(count);
		sc.close();
	}

}
