package com.ssafy.level3;

import java.util.Scanner;

public class SWEA_7272 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++){

			String one = sc.next(); //첫번째 문자열
			String two = sc.next(); //두번째 문자열
			boolean isSame = true;
			String result = "";

			if(one.length()==two.length()) {
				
				for(int i=0; i<one.length(); i++) { //첫번째와 두번째 문자열 비교
					if(one.charAt(i)=='B' && two.charAt(i)!='B') {
						isSame = false;
						break;
					}
					else if((one.charAt(i)=='A'||one.charAt(i)=='D'||one.charAt(i)=='O'||one.charAt(i)=='P'||one.charAt(i)=='Q'||one.charAt(i)=='R')
							&&(two.charAt(i)!='A'&&two.charAt(i)!='D'&&two.charAt(i)!='O'&&two.charAt(i)!='P'&&two.charAt(i)!='Q'&&two.charAt(i)!='R')) {
						isSame = false;
						break;						
					}
				}

				for(int i=0; i<two.length(); i++) { //두번째와 첫번째 문자열 비교 (순서를 바꿔서)
					if(two.charAt(i)=='B' && one.charAt(i)!='B') {
						isSame = false;
						break;
					}
					else if((two.charAt(i)=='A'||two.charAt(i)=='D'||two.charAt(i)=='O'||two.charAt(i)=='P'||two.charAt(i)=='Q'||two.charAt(i)=='R')
							&&(one.charAt(i)!='A'&&one.charAt(i)!='D'&&one.charAt(i)!='O'&&one.charAt(i)!='P'&&one.charAt(i)!='Q'&&one.charAt(i)!='R')) {
						isSame = false;
						break;						
					}
				}

			}else {
				isSame = false;
			}

			result = (isSame)? "SAME" : "DIFF";
			System.out.printf("#%d %s%n", test_case, result);
		}
	}
}
