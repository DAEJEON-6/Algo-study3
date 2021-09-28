package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// BOJ 14938. 서강그라운드
public class BOJ_14938 {

	static ArrayList<Vertex>[] graph;
	static int[] distance;
	static boolean[] check;
	static int[] item;
	static int n,m,r;
	
	private static class Vertex implements Comparable<Vertex>{
		int num;
		int distance;
		
		public Vertex(int num, int distance) {
			this.num = num;
			this.distance = distance;
		}

		@Override
		public int compareTo(Vertex o) {
			// 오름차순 정렬
			return this.distance - o.distance;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());  // 지역 개수 n
		m = Integer.parseInt(st.nextToken());  // 수색 범위 m
		r = Integer.parseInt(st.nextToken());  // 길의 개수 r
		graph = new ArrayList[n+1];
		item = new int[n+1];
		check = new boolean[n+1];
		distance = new int[n+1];
		// n개의 각 구역에 있는 아이템 수 저장
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayList<Vertex>(); 
			item[i] = Integer.parseInt(st.nextToken());
		}
		// 지역 a -> 지역 b 길의 길이 l 저장
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			// 무방향 그래프
			graph[a].add(new Vertex(b,l));
			graph[b].add(new Vertex(a,l));
		}
		int maxNum = 0;
		// 각 지역에서 시작해보고 최대값 구한다.
		for(int i=1; i<= n; i++) {
			maxNum = Math.max(maxNum, djikstra(i));
		}
		System.out.println(maxNum);
	}
	// 다익스트라
	private static int djikstra(int start) {
		int itemTotal =0;
		Arrays.fill(distance, Integer.MAX_VALUE);
		Arrays.fill(check, false);
		
		PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		queue.offer(new Vertex(start, 0));
		distance[start] = 0; 
		
		while(!queue.isEmpty()) {
			Vertex current = queue.poll();
			int no = current.num;
			
			if(check[no]) continue;
			check[no] = true;
			
			// start 노드에 인접해있는 노드들 방문
			for(Vertex vertex: graph[no]) {
				if(!check[vertex.num] && distance[vertex.num] > distance[no] + vertex.distance) {
					distance[vertex.num] = distance[no]+ vertex.distance;
					// no번 노드에 인접해 있는 노드들 queue에 저장
					queue.offer(new Vertex(vertex.num, distance[vertex.num]));
				}
			}
		}
		// distance배열에는 start노드에서 다른 각 노드로의 최단 거리가 저장됨.
		// 각 노드로 향하는 거리 < 제한범위 m => itemTotal에 획득한 아이템 개수 누적합.
		for(int i=1; i<=n; i++) {
			if(distance[i] <= m) {
				itemTotal+= item[i];
			}
		}
		return itemTotal;
	}

}
