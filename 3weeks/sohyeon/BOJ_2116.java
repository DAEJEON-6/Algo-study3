package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ 2116. 주사위 쌓기
public class BOJ_2116 {

	static int N; // 주사위 개수
	static Integer[][] dices; // 주사위 정보
	static int[] getmax;  // 주사위 1번을 놓는 경우의 수 6가지의 각 최대값 저장

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dices = new Integer[N][6];
		getmax = new int[6];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<6;j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		selectDice1();  
		Arrays.sort(getmax); 
		System.out.println(getmax[getmax.length-1]);
	}
	// 주사위 1번을 어떻게 놓느냐에 따라 2~6번 주사위의 놓는 상태가 정해진다.
	public static void selectDice1() {
		int next = 0;
		// 1번 주사위 6가지 경우
		for (int i = 0; i < 6; i++) {		
			next=dices[0][i];
			next = getNext(0, next, i);  // 1번 주사위 윗면 찾기 (2번주사위의 시작 번호 찾기)
			for (int j = 1; j < N; j++) {
				next = getNext(j, next, i);  // 나머지 주사위 윗면 찾기
			}
		}
	}
	// 주사위 옆 면 최대값 구하고, 그 다음 주사위와 만날 숫자 구하기
	// i : 주사위 번호, next : 아랫 면, maxIndex : 주사위1번 경우의 수
	public static int getNext(int i, int next, int maxIndex) { 
		int max = Integer.MIN_VALUE, index1=0;
		// 이전 주사위의 윗면 숫자에 해당하는 현재 주사위 숫자의 index구하기 => 현재 주사위 아랫면 index
		for(int m=0; m<6; m++) {
			if(dices[i][m]==next) {
				index1=m;
				break;
			}
		}
		if (index1 == 0 || index1 == 5) {
			// 옆면 최대값 구하기
			for (int j = 1; j < 5; j++) {
				max = Math.max(max, dices[i][j]);
			}
			getmax[maxIndex] += max;	
			// 반대편 숫자 저장 (다음 주사위에 영향)
			if (index1 == 0)
				next = dices[i][5];
			else if (index1 == 5)
				next = dices[i][0];
		} else {
			// 반대편 숫자 저장 (다음 주사위에 영향)
			int index2=0;  // index2 : 현재 주사위의 윗면 index
			if (index1 == 1 || index1 == 2) {
				index2=index1+2;
				next = dices[i][index1 + 2];
			}
			else if (index1 == 3 || index1 == 4) {
				index2=index1-2;
				next = dices[i][index1 - 2];
			}
			// 옆 면 최대값 구하기
			for (int j = 0; j < 6; j++) {
				if (j != index1 && j != index2)
					max = Math.max(max, dices[i][j]);
			}
			getmax[maxIndex] += max;
		}
		return next;
	}
}
