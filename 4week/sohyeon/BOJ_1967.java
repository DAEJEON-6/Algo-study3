package algo.study.boj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// BOJ 1967. 트리의 지름
public class BOJ_1967 {

	static class Edge{
		int value,weight;
		public Edge(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}
	}
	
	static int N;  // 노드의 개수
	static boolean isVisited[];
	static List<Edge>[] graph;
	static int max=0, idx=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		StringTokenizer st = null;
		for(int i=1; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[parent].add(new Edge(child, weight));
			graph[child].add(new Edge(parent, weight));
		}
		
		// dfs -> 트리의 지름 찾기
		isVisited = new boolean[N+1];
		dfs(1,0);
		isVisited = new boolean[N+1];
		dfs(idx, 0);
		
		System.out.println(max);
	}

	public static void dfs(int v, int w) {
		isVisited[v] = true;
		// 트리의 지름이 최대값보다 크다면
		if(w > max) {
			idx = v;
			max = w;
		}
		for(Edge e : graph[v]) {
			if(!isVisited[e.value]) {
				dfs(e.value, w+e.weight);
			}
		}
	}
}
