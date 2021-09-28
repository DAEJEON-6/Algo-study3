package programmers.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Programmers 42885. 구명보트
public class Programmers_42885 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 사람 수
		int[] people = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		int limit = Integer.parseInt(br.readLine()); // 제한 무게
		System.out.println(solution(people, limit));
	}

	public static int solution(int[] people, int limit) {
		int answer = 0;
		// 무게순 오름차순 정렬
		Arrays.sort(people);
		
		int first=0;  // 보트에 오를 첫 사람 인덱스
		int second=people.length-1;  // 보트에 오를 두번째 사람 인덱스
		
		// 처음 사람과 두번째 사람이 같아질 때까지 반복
		while(first <= second) {
			int head = people[first];
			int tail = people[second];
			
			// 처음 사람의 무게와 두번째 사람의 무게의 합이 제한보다 작거나 같으면
			if(head + tail <= limit) first++;  // 첫 사람도 배에 탈 수 있으므로 첫 사람 인덱스를 다음으로 이동
			
			// 마지막 사람은 처음 사람과의 무게의 합이 제한보다 큰지 작은지에 상관없이 항상 배에 먼저 태움(greedy)
			// => 마지막 사람 인덱스는 항상 하나 감소
			second--;
			answer++;
		}
		return answer;
	}
}
