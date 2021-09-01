package algo.study.swea.d3;

import java.util.Scanner;

// SWEA D3 7272. 안경이 없어!
public class SWEA_7272 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		String s1, s2;
		char[] holeChar = { 'A', 'D', 'O', 'P', 'Q', 'R' };
		char checkB = 'B';

		for (int test_case = 1; test_case <= T; test_case++) {
			s1 = sc.next();
			s2 = sc.next();
			int[] checkS1 = new int[s1.length()];
			int[] checkS2 = new int[s2.length()];

			for (int i = 0; i < s1.length(); i++) {
				checkS1[i] = 0;
				for (int j = 0; j < holeChar.length; j++) {
					if (s1.charAt(i) == holeChar[j]) {
						checkS1[i] = 1;
						break;
					}
				}
				if(s1.charAt(i) == checkB) {
					checkS1[i] = 2;
				}
			}

			for (int i = 0; i < s2.length(); i++) {
				checkS2[i] = 0;
				for (int j = 0; j < holeChar.length; j++) {
					if (s2.charAt(i) == holeChar[j]) {
						checkS2[i] = 1;
						break;
					}
				}
				if(s2.charAt(i) == checkB) {
					checkS2[i] = 2;
				}
			}
			
			int cnt = 0;
			if (s1.length() == s2.length()) {
				for (int i = 0; i < s1.length(); i++) {
					if (checkS1[i] != checkS2[i]) {  // 다르면
						System.out.printf("#%d %s%n", test_case, "DIFF");
						break;
					} else {  // 같으면
						cnt++;
						if (cnt == s1.length()) {
							System.out.printf("#%d %s%n", test_case, "SAME");
						}
					}
				}
			} else
				System.out.printf("#%d %s%n", test_case, "DIFF");
		}
		
		sc.close();
	}

}
