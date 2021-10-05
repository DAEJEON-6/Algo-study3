import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-08-24
 * Description : 백준 1753
 */

public class Main{
	//간선 정보를 저장할 노드
	public static class Node{
		int end,weight;
		Node link;
		Node(int end, int weight, Node link){
			this.end = end;
			this.weight = weight;
			this.link = link;
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//정점의 갯수, 간선의 갯수, 시작지점
		int V = Integer.parseInt(st.nextToken())+1;
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		//노드를 저장할 노드 리스트 생성
		Node[] lst = new Node[V];
		// 입력
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			lst[u] = new Node(v,w,lst[u]);
		}
		
		//거리 초기화
		int distance[] = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		//방문 여부 배열
		boolean visited[] = new boolean[V];
		for(int i=1; i<V; i++) {
			
			//1. 시작점에서 다음까지 최소거리
			int min = Integer.MAX_VALUE;
			int current = -1;
			for(int j=1; j<V; j++) {
				if(!visited[j] && min>distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			if(current==-1) break;
			visited[current] = true;
			
			//2. 방문하지 않았고 간선이 존재하며,
			//min+vertex가 해당 distance보다 작다
			//cur에 있는 정점 확인
			for(Node node = lst[current]; node!=null; node = node.link) {
				if(!visited[node.end] && distance[node.end]>min+node.weight) {
					distance[node.end] = min+node.weight;
				}
			}
		}
		//출력		
		for(int i=1; i<V; i++) {
			if(distance[i]==Integer.MAX_VALUE){
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
		
	}
}
