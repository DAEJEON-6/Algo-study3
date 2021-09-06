package programmers.weeklychallenge.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Programmers 84512. 모음 사전
public class Programmers_84512 {

	static String[] vowel = {"A","E","I","O","U"};
	static int cnt=0;
	static int answer=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String Alphabet = br.readLine();  // 입력 word
		System.out.println(solution(Alphabet));
	}

	public static int solution(String word) {
		permutation(0, "", word);
        return answer;
    }
	// 중복 순열
	public static void permutation(int idx, String alphabet, String word) {
		if(idx == 5) return;
		
		for(int i=0; i<vowel.length; i++) {
			String s = alphabet + vowel[i];
			cnt++;
			if(s.equals(word)) {
				answer = cnt;
				return;
			}
			permutation(idx+1, s, word);
		}
	}
}
