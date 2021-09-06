package programmers.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Programmers 42860. 조이스틱
public class Programmers_42860 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();

		System.out.println(solution(name));
	}

	public static int solution(String name) {
		int answer = 0;
		int move = name.length() - 1;
		for (int i = 0; i < name.length(); i++) {
			answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
			int next = i + 1; // 다음 알파벳
			// 다음 알파벳이 A인 경우
			while (next < name.length() && name.charAt(next) == 'A') {
				next++;
			}
			move = Math.min(move, (i + i) + (name.length() - next));
		}
		answer += move;
		return answer;
	}
}
