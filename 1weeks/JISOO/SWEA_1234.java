package com.ssafy.level3;

import java.util.Scanner;

public class SWEA_1234 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int num = sc.nextInt();
			String str = sc.next();
			StringBuilder sb = new StringBuilder(str);

			int i = 0;

			while(i < sb.length()-1) {
				if(sb.charAt(i) == sb.charAt(i+1)) { //이웃하는 문자열이 같다	
					sb.deleteCharAt(i); //해당 문자열 제거
					sb.deleteCharAt(i); //다음 문자열도 제거 (이미 전에서 제거가 일어나 같은 인덱스에 있는 값을 또 지운다)
					i = 0; //다시 문자열의 처음부터 탐색하기 위함
				}
				else{
					i++; //다음 문자열 탐색
				}
			}
			System.out.printf("#%d %s", test_case, sb);
		}
	}

}
