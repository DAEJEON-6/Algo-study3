package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BOJ 17142. 연구소 3
public class BOJ_17142 {

	static int N;  // 연구소 크기 N*N
	static int M;  // 놓을 수 있는 바이러스 개수
	static int[][] map;
	static LinkedList<Virus> viruslist;
	static int blankcnt=0;  // map에서 빈칸 개수
	static int result = Integer.MAX_VALUE;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};  // 상 우 하 좌
	static class Virus{
		int x,y;
		public Virus(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		viruslist = new LinkedList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				// 바이러스 위치 저장
				if(map[i][j]==2) viruslist.add(new Virus(i,j));
				else if(map[i][j]==0) blankcnt++;  // 빈칸 개수 카운트
			}
		}
		// 활성 바이러스 선택
		setActivate(0,0);
		if(result==Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(result);
	}
	private static void setActivate(int idx, int cnt) {
		if(cnt==M) {
			bfs();
			return;
		}
		if(idx>=viruslist.size()) return;
		for(int i=idx; i<viruslist.size(); i++) {
			Virus v = viruslist.get(i);
			map[v.x][v.y]=3;  // 활성
			setActivate(i+1, cnt+1);
			map[v.x][v.y]=2;  // 비활성
		}
	}
	private static void bfs() {
		Queue<Virus> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		int[][] tmpmap = new int[N][N];  // 원본 map 복사
		for(int i=0; i<N; i++) {
			tmpmap[i] = Arrays.copyOf(map[i], map[i].length);
			for(int j=0; j<N; j++) {
				// 활성화 바이러스인 경우
				if(tmpmap[i][j]==3) {
					Virus v = new Virus(i,j);
					queue.offer(v);
					// 시작 지점 방문표시
					visited[v.x][v.y]=true; 
				}
			}
		}
		
		int time=0;
		int tmpblankcnt = blankcnt;  // 빈칸 개수
		while(!queue.isEmpty()) {
			// 빈칸 있는지 체크
			if(tmpblankcnt==0) break;
			// 현재의 탐색이 이전 기록보다 더 크면 그만!
			if(result != Integer.MAX_VALUE && result<time) return;
			// 매 초 queue의 바이러스만큼 복제
			int queuesize = queue.size();
			while(queuesize-- >0) {
				Virus v = queue.poll();
				for(int i=0; i<4; i++) {
					int nx = v.x + deltas[i][0];
					int ny = v.y + deltas[i][1];
					// 범위 체크
					if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
					// 방문 안한 곳 && 벽이 아닌 곳
					if(!visited[nx][ny] && tmpmap[nx][ny]!=1) {
						if(tmpmap[nx][ny]==0) tmpblankcnt--;  // 빈칸 개수 감소
						visited[nx][ny]=true;  // 방문 표시
						tmpmap[nx][ny]=3;  // 활성상태 바이러스로 변경
						queue.offer(new Virus(nx,ny));  // bfs
					}
				}
			}
			time++;  // 1초경과
		}
		// bfs가 끝나고 바이러스 완전히 복제되었는지 여부 체크
		if(tmpblankcnt==0) result = Math.min(result, time);
	}

}
// 0 : 빈칸
// 1 : 벽
// 2 : 비활성 바이러스
// 3 : 활성 바이러스