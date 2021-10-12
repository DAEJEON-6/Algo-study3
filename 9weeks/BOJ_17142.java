import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17142 {

	private static int N, M, EmptyCnt;
	private static int Min = Integer.MAX_VALUE;
	private static int[][]map;
	private static int[]selected; //초기에 활성화시킬 바이러스의 인덱스
	private static int[][]delta = {{-1,0},{0,1},{1,0},{0,-1}};

	private static ArrayList<Virus>virusList; //바이러스의 위치 저장
	private static class Virus{
		int r;
		int c;
		public Virus(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //배열 사이즈
		M = Integer.parseInt(st.nextToken()); //초기에 활성화시킬 바이러스 개수

		map = new int[N][N];
		virusList = new ArrayList<Virus>(); //모든 바이러스의 위치를 저장
		selected = new int[M]; //초기 활성화될 바이러스의 인덱스 저장

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) { //바이러스를 퍼뜨려야할 빈 칸의 개수
					EmptyCnt++;
				}else if(map[i][j] == 2) { //바이러스의 위치를 저장
					virusList.add(new Virus(i, j));
				}
			}
		}
		
		if(EmptyCnt == 0) { //빈 칸이 없는 경우
			System.out.println(0);
			System.exit(0);
		}

		combination(0, 0);

		if(Min != Integer.MAX_VALUE) {
			System.out.println(Min);
		}else {
			System.out.println(-1);
		}
	}

	private static void combination(int cnt, int ind) { //M개의 초기 활성화된 바이러스 조합 구하기
		if(cnt == M) {
			int temp = bfs();
			if(temp < Min) { //현재 조합으로 최소시간이 발생한 경우, 최소 시간 갱신
				Min = temp;
			}
			return;
		}

		for(int i=ind; i<virusList.size(); i++) {
			selected[cnt] = i;
			combination(cnt+1, i+1);
		}
	}

	private static int bfs() {
		boolean[][]visited = new boolean[N][N];
		Queue<Virus>queue = new LinkedList<>();

		for(int i=0; i<M; i++) { //조합된 초기 활성화된 바이러스의 위치를 큐에 저장, 방문처리
			Virus active = virusList.get(selected[i]);
			queue.offer(new Virus(active.r, active.c));
			visited[active.r][active.c] = true;
		}

		int time = 0;
		int virusCnt = 0; //빈 칸에 퍼진 바이러스의 개수
		boolean flag = false; //모든 빈 칸에 바이러스가 확산되었나 확인

		while(!queue.isEmpty()) {
			int size = queue.size(); //pop하기 전 큐의 사이즈
			for(int i=0; i<size; i++) {
				Virus cur = queue.poll();
				int r = cur.r;
				int c = cur.c;

				for(int j=0; j<4; j++) { //사방탐색
					int nr = r+delta[j][0];
					int nc = c+delta[j][1];

					//다음 가야하는 곳이 범위 안에 있고, 방문되지 않았고, 벽이 아닌 경우 (빈 칸이거나 비활성화된 곳)
					if(nr>=0 && nr<N && nc>=0 && nc<N && !visited[nr][nc] && map[nr][nc]!=1) {
						if(map[nr][nc] == 0) { //빈 칸인 경우, 바이러스가 새롭게 확산
							virusCnt++;
						}
						//빈 칸이거나 비활성화된 곳은 방문처리 해주고 큐에 넣어줌으로 활성화 시키기 
						queue.offer(new Virus(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}
			if(virusCnt == EmptyCnt) { //모든 빈 칸에 바이러스가 확산된 경우
				flag = true;
				break;
			}
			time++; //현재 큐의 레벨에 있는 모든 원소들이 pop되면 시간 증가시키기
		}

		if(flag) { //모든 빈 칸에 바이러스가 확산된 경우, 확산된 시간을 리턴
			return time+1;
		}else {
			return Integer.MAX_VALUE;
		}
	}
}