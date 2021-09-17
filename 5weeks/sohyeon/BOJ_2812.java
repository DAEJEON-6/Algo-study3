package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// BOJ 2812. 크게 만들기
public class BOJ_2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());  // N자리 숫자
		int K = Integer.parseInt(st.nextToken());  // 숫자 K개 
		String number = br.readLine();  // 입력받은 숫자
		
		Deque<Integer> deque = new ArrayDeque<>(); 
		for(int i=0; i<N; i++) {
			// deque가 비어있으면
			if(deque.isEmpty()) {
				deque.addLast(number.charAt(i)-'0');
			}else {
				// 뺄 수 있는 수가 있고, deque가 비어있지 않다면 계속 비교
				while (K>0 && !deque.isEmpty() && deque.peekLast()<(number.charAt(i)-'0')) {
					deque.pollLast();
					K--;
				}
				deque.addLast(number.charAt(i)-'0');
			}
		}
		// 더 뺄 수 있는 수가 있으면 다 빼주기
		while(K-- >0) {
			deque.pollLast();
		}
		
		for(Integer i : deque) {
			System.out.print(i);
		}
	}

}