import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9466 {
	private static int cycle, num;
	private static int[]map;
	private static boolean[]cycled;
	private static boolean[]visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for(int i=0; i<T; i++) {
			cycle = 0; //사이클에 포함되는 노드의 개수

			num = Integer.parseInt(br.readLine());
			map = new int[num+1]; //학생별 선택 결과
			cycled = new boolean[num+1]; //각 노드가 이미 사이클에 포함되었는지 확인
			visited = new boolean[num+1];

			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=num; j++) {
				map[j] = Integer.parseInt(st.nextToken());
			}

			for(int j=1; j<=num; j++) {
				if(!cycled[j]) {
					visited[j] = true; 
					dfs(j, j);
					visited[j] = false;
				}
			}

			System.out.println(num-cycle);
		}
	}

	private static void dfs(int start, int next) {
		if(start==map[next]) { //사이클이 생긴 경우
			for(int i=0; i<visited.length; i++) {
				if(visited[i]==true) { //사이클에 포함되는 모든 노드들을 재방문하지 않음
					cycled[i] = true;
					cycle++;
				}
			}
			return;
		} 

		if(!visited[map[next]]) {
			visited[map[next]] = true;
			dfs(start, map[next]);
			visited[map[next]] = false;
		}else { //시작 정점이 아닌 다른 노드를 이미 방문한 경우 (시작 정점을 포함하지 않고 사이클이 생긴 경우)
			return;
		}
	}
}
