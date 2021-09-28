package programmers.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// Programmers 42883. 큰 수 만들기
public class Programmers_42883 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		int k = Integer.parseInt(br.readLine());
		System.out.println(solution(number, k));
	}

	public static String solution(String number, int k) {
		String answer = "";
		Deque<Integer> deque = new ArrayDeque<>(); 
		for(int i=0; i<number.length(); i++) {
			// deque가 비어있으면
			if(deque.isEmpty()) {
				deque.addLast(number.charAt(i)-'0');
			}else {
				// 뺄 수 있는 수가 있고, deque가 비어있지 않다면 계속 비교
				while (k>0 && !deque.isEmpty() && deque.peekLast()<(number.charAt(i)-'0')) {
					deque.pollLast();
					k--;
				}
				deque.addLast(number.charAt(i)-'0');
			}
		}
		// 더 뺄 수 있는 수가 있으면 다 빼주기
		while(k-- >0) {
			deque.pollLast();
		}
		
		for(Integer i : deque) {
			answer+=i;
		}
		return answer;
	}
}
