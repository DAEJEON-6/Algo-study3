import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11779 {
	private static class Node implements Comparable<Node>{
		int to;
		int weight;
		public Node(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight; //가중치 순으로 오름차순 정렬
		}
	}
	private static final int MAX = 100_000_000;
	private static int N, M;
	private static ArrayList<Node>[]adjList; //인접리스트
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //도시 수
		M = Integer.parseInt(br.readLine()); //버스 수

		adjList = new ArrayList[N+1]; //도시 번호는 1부터 시작
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for(int i=0; i<M; i++) { //버스 정보를 입력 받고 도시들 연결해주기
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Node(to, weight));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start, end);
	}

	private static void dijkstra(int start, int end) { //다익스트라 알고리즘
		PriorityQueue<Node>pq = new PriorityQueue<>();
		boolean[]visited = new boolean[N+1];
		int[]parents = new int[N+1]; //각 정점에 대해 부모정점을 저장
		int[]dist = new int[N+1];

		Arrays.fill(dist, MAX);

		dist[start] = 0;
		parents[start] = -1;
		pq.offer(new Node(start, 0));

		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int next = cur.to;
			
			if(!visited[next]) { //이미 방문한 정점은 스킵
				visited[next] = true;

				for(Node e: adjList[next]) { //현재 선택된 정점에 연결된 정점들 확인
					if(!visited[e.to] && dist[e.to] > dist[next]+e.weight) {
						dist[e.to] = dist[next]+e.weight;
						pq.offer(new Node(e.to, dist[e.to]));
						parents[e.to] = next;
					}
				}
			}
		} 
		
		
		//도시의 방문 순서 구하기
		int cnt = 0;
		int index = end;
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			int parentVal = parents[index];
			
			sb.append(index+ " ");
			cnt++;
			index = parentVal;
			
			if(parentVal == -1) {
				break;
			}
		}
		
		sb.setLength(sb.length()-1);
		sb.reverse();
		System.out.println(dist[end]+"\n"+cnt+"\n"+sb);
	}

}
