package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ 11779. 최소비용 구하기2
public class BOJ_11779 {

	static int n;  // 도시 개수
	static int m;  // 버스 개수 
	static ArrayList<Bus>[] list;
	static int[] route;
	static int[] cost;
	static class Bus implements Comparable<Bus>{
		int to;
		int cost;
		public Bus(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Bus o) {
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];  // 인접 리스트
		for(int i=1; i<=n; i++) list[i] = new ArrayList<>();
		
		// 버스 정보 저장
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Bus(to,cost));
		}
		st = new StringTokenizer(br.readLine()," ");
		int start = Integer.parseInt(st.nextToken());  // 출발점 도시 번호
		int end = Integer.parseInt(st.nextToken());  // 도착점 도시 번호 
		
		// 다익스트라 구현 위한 초기값 설정
		route = new int[n+1];  // 경로 찾기 위함
		cost = new int[n+1];  // cost 저장 위함
		Arrays.fill(cost, Integer.MAX_VALUE);
		dijkstra(start, end);
		// 도착지점까지 최소 비용
		System.out.println(cost[end]);
		
		searchRoute(end);
	}
	// 다익스트라
	public static void dijkstra(int start, int end) {
		PriorityQueue<Bus> pq = new PriorityQueue<>();
		cost[start]=0;
		route[start]=0;
		pq.offer(new Bus(start, 0));
		
		while(!pq.isEmpty()) {
			Bus bus = pq.poll();
			// 우선순위큐이기 때문에 최소비용 경로가 가장 우선.
			// 바로 break; 해도 무관!
			if(bus.to==end) break;
			
			for(int i=0; i<list[bus.to].size(); i++) {
				int dest = list[bus.to].get(i).to;
				int c = list[bus.to].get(i).cost;
				
				// 현재까지 탐색한 값들의 목적지까지 비용이 지금 탐색 중인 값보다 크면
				// 더 작은값으로 초기화
				if(cost[dest] > cost[bus.to]+ c) {
					cost[dest] = cost[bus.to]+ c;
					pq.offer(new Bus(dest, cost[dest]));
					route[dest]=bus.to;
				}
			}
		}
	}
	// 경로 탐색
	public static void searchRoute(int end) {
		ArrayList<Integer> routelist = new ArrayList<>();
		int find = end;
		// route 배열을 역으로 추적해서 방문 경로 탐색
		while(find != 0) {
			routelist.add(find);
			find = route[find];  // 지나온 경로 확인
		}
		// 경로 탐색 결과 몇개 지점 거쳤는지 출력
		// routelist크기 = 현재까지 방문한 경로의 수 
		System.out.println(routelist.size());
		
		// 역으로 저장했기 때문에
		// 도착지 ~ 시작점 순으로 저장되어 있다.
		// 출력을 거꾸로 해준다.
		for(int i=routelist.size()-1; i>=0; i--) {
			System.out.print(routelist.get(i) + " ");
		}
	}
}
