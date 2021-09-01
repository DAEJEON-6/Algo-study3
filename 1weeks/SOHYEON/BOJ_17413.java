package algo.study.boj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ 17413. 단어 뒤집기2
public class BOJ_17413 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Stack<Character> stack = new Stack<Character>();
		String s = br.readLine();
		int len = s.length();

		for (int i = 0; i < len; i++) {
			if (s.charAt(i) == '<') {  // 괄호 내부 처리
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append('<');
				while (s.charAt(i++) != '>') {
					sb.append(s.charAt(i));
				}
				i--;
			} else if (s.charAt(i) == ' ') {  // 공백만나면 FILO형식으로 출력
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			} else {  // 공백문자나 괄호안 문자들이 아니면 push
				stack.push(s.charAt(i));
			}
		}
		
		// 위의 for문에서는 공백을 만나면 pop했기 때문에
		// 문자열의 시작과 끝은 공백이 아니므로 pop을 최종적으로 다시 해준다.
		while (!stack.isEmpty()) {  
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}
}