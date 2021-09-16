package programmers.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Programmers 42748. K번째수
public class Programmers_42748 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		int[][] commands = new int[m][3];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) {
				commands[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] result = solution(array, commands);
		print(result);
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for(int i=0; i<commands.length; i++) {
			int size = commands[i][1] - commands[i][0] + 1;
			// 잘라낸 새로운 배열
			int[] subarray = new int[size];  
			for(int j=0; j<size; j++) {
				subarray[j] = array[commands[i][0]-1+j];  // 1번째 원소는 [0]임을 유의
			}
			// 정렬
			Arrays.sort(subarray);
			// k번째 숫자
			answer[i] = subarray[commands[i][2]-1];  // 1번째 원소는 [0]임을 유의
		}
		return answer;
	}
	public static void print(int[] ary) {
		for(int i=0; i<ary.length; i++) {
			System.out.print(ary[i] + " ");
		}
		System.out.println();
	}
}
/*
7
1 5 2 6 3 7 4
3
2 5 3
4 4 1
1 7 3
 */
