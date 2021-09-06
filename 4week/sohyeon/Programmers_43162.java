package programmers.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Programmers 43162. 네트워크
public class Programmers_43162 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());  // 컴퓨터 개수 n
		int[][]computers = new int[n][3];  // 컴퓨터번호(0~n-1) / i번 컴퓨터와 j번 컴퓨터 연결 상태(1 or 0)
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) {
				computers[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solution(n, computers));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] isVisited = new boolean[computers.length];
		
		for(int i=0; i<computers.length; i++) {
			if(isVisited[i]==false) {
				answer++;
				dfs(i,isVisited,computers);
			}
		}
		return answer;
	}
	
	public static void dfs(int index, boolean[] isVisited, int[][] computers) {
		isVisited[index] = true;
		for(int i=0; i<computers.length; i++) {
			if(isVisited[i]==false && computers[index][i]==1) {
				dfs(i,isVisited,computers);
			}
		}
	}
}
