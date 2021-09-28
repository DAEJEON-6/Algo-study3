import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916 {
	static class Node implements Comparable<Node>{
		int next;
		int weight;
		public Node(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return this.weight-o.weight; //가중치 오름차순으로 정렬
		}
	}
	
	static int N; //도시 개수
	static ArrayList<Node>[] list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine()); //버스 개수
	
		list = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(startCity, endCity));
		
	}

	private static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] isVisited = new boolean[N+1]; //각 도시의 방문여부
		int[] dist = new int[N+1]; //시작 도시부터 각 도시까지의 최단 거리 저장
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			int next = curNode.next;
			
			if(!isVisited[next]) {
				isVisited[next] = true;
				
				for(Node node: list[next]) {
					if(!isVisited[node.next] && dist[node.next] > dist[next]+node.weight) {
						dist[node.next] = dist[next]+node.weight;
						pq.add(new Node(node.next, dist[node.next]));
					}
				}
			}
		}
		return dist[end];
	}

}
