package algo.study.swea.d3;

import java.util.LinkedList;
import java.util.Scanner;

// SWEA D3 1234. [S/W 문제해결 기본] 10일차 - 비밀번호
public class SWEA_1234 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int size = 10;
		
		for(int test_case=1; test_case<=size; test_case++) {
			int N = sc.nextInt();  // 문자열 길이
			LinkedList<Character> password = new LinkedList<Character>();  // 비밀번호
			String s = sc.next();
			
			for(int i=0; i<N; i++) {
				// List의 마지막과 같으면 
				if(!password.isEmpty() && password.getLast() == s.charAt(i)) {
					password.removeLast();  // 삭제
				}else {  // 다르면
					password.add(s.charAt(i));  // 추가
				}
			}
			System.out.printf("#%d ", test_case);
			for(char c : password) System.out.print(c);
			System.out.println();
		}
		sc.close();
	}

}