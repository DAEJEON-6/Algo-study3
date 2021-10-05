package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ 9466. 텀 프로젝트
public class BOJ_9466 {

	static int[] studentNum;
	static boolean[] isVisited;  // 방문 여부
	static boolean[] team;  // 한 사이클에 포함여부
	static int cnt; // 팀완성 인원 수

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수 T
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine()); // 학생 수
			studentNum = new int[n + 1];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= n; i++) {
				studentNum[i] = Integer.parseInt(st.nextToken());
			}

			isVisited = new boolean[n + 1];
			team = new boolean[n + 1];

			cnt=0;
			for(int i=1; i<=n; i++) {
				dfs(i);
			}
			System.out.println(n-cnt);  // 전체 학생 수 - 사이클 이루는 노드 개수
		}

	}

	// dfs
	public static void dfs(int index) {
		// 이미 방문했으면 dfs 탐색 X
		if(isVisited[index]) return;
		
		isVisited[index] = true;  // 방문처리
		int next = studentNum[index];  // index번 학생이 선택한 학생 번호
		
		if(!isVisited[next]) dfs(next);
		else {  // 다음 노드가 이미 방문한 노드라면 -> 사이클 이루는가? 확인
			if(!team[next]) {  // 사이클 이루는 노드가 X
				cnt++;
				for(int i=next; i!=index; i=studentNum[i]) {  // 그래프 연결 따라가는 for문
					cnt++;  // 연결된 학생 존재할때마다 누적
				}
			}
			
		}
		team[index] = true;  // 다 끝나면 현재노드는 더이상 사용 X
	}
}
