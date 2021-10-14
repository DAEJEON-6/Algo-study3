package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// BOJ 9935. 문자열 폭발
public class BOJ_9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String boom = br.readLine();
		System.out.println(bomb(str, boom));
	}
	public static String bomb(String str, String boom) {
		// 문자열 담을 deque
		Deque<Character> dq = new ArrayDeque<>();
		Stack<Character> st = new Stack<>();  // 폭발되는 문자열 스택
		
		for(int i=0; i<str.length(); i++) {
			dq.addLast(str.charAt(i));  // 문자열을 deque에 담는다.
			// deque 문자열 길이가 폭발 문자열 길이보다 큰 경우에만 검사
			if(dq.size()>=boom.length()) {
				int j = boom.length()-1;
				while(true) {
					// 뒤에서 부터 체크
					if(dq.peekLast() == boom.charAt(j)) {
						st.add(dq.pollLast());  // 폭발문자와 일치하면 스택에 add
						j--;
					}else {
						// 폭발되지 않은 경우 스택 문자열 가져오기
						while(st.size()>0) {
							dq.addLast(st.pop());
						}
						break;
					}
					// 폭발 문자열 == 검사한 문자열
					if(j==-1) {
						st.clear();  // 스택 초기화
						break;
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		// 남은 문자열 합치기
		while(dq.size()>0) {
			sb.append(dq.pollFirst());
		}
		// 합친 문자열 길이 0이면 FRULA 리턴
		return (sb.length()==0) ? "FRULA" : sb.toString();
	}

}
