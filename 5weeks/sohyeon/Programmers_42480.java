package programmers.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//Programmers 42748. 모의고사
public class Programmers_42480 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 시험 문제 개수 n개
		int[] answers = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < answers.length; i++) {
			answers[i] = Integer.parseInt(st.nextToken());
		}
		int[] result = solution(answers);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
	}

	public static int[] solution(int[] answers) {
		int[] score = new int[3];
		int[] mathgiveup1 = new int[] { 1, 2, 3, 4, 5 };
		int[] mathgiveup2 = new int[] { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] mathgiveup3 = new int[] { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		// 문제 answer를 각각 1번, 2번, 3번 수포자
		score[0] = getScore(mathgiveup1, answers);
		score[1] = getScore(mathgiveup2, answers);
		score[2] = getScore(mathgiveup3, answers);
		// -> score 배열에 각 학생의 점수 저장
		int max = getMax(score);  // score 최대값 구하기
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<3; i++) {
			if(max == score[i]) {
				list.add(i+1);
			}
		}
		
		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	public static int getScore(int[] student, int[] answers) {
		int score = 0;
		for (int i = 0; i < answers.length; i++) {
			// 정답이라면
			if (answers[i] == student[i % student.length]) {
				score++;
			}
		}
		return score;
	}

	// score 최대값 구하는 함수
	public static int getMax(int[] score) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<score.length; i++) {
			max = Math.max(max,  score[i]);
		}
		return max;
	}
}
/*
input
5
1 2 3 4 5
output
1

input
5
1 3 2 4 2
output
1 2 3

 */