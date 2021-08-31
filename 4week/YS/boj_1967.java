import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-01
 * Description : 백준 1967
 */

public class Main{
  //DFS 정보를 저장할 노드
	public static class Node{
		int next, weight;
		Node link;
		
		Node(int next, int weight, Node link){
			this.next = next;
			this.weight = weight;
			this.link = link;
		}
	}
	//노드의수, 노드배열, 방문 리스트
	static int N ;
	static Node[] node;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//노드의 개수
		N = Integer.parseInt(br.readLine());
		//노드 배열 생성
		node = new Node[N+1];
		//방문 리스트 생성
		visited = new boolean[N+1];
		//인접 리스트 입력
		for(int i=1; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int curr = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			//양방향입니당
			node[curr] = new Node(next,weight,node[curr]);
			node[next] = new Node(curr,weight,node[next]);
		}
    //1번부터 시작하니 방문하고 시작
		visited[1] = true;
		DFS(1);
		//출력
		System.out.println(max_value);
		
	}
	//지름의 최댓값
	static int max_value = 0;
	
	public static int DFS(int n) {
    //노드수가 1일때 or 마지막 노드이고 첫번째 노드가 아닐때
		if(node[n]==null || (node[n].link==null && n!=1) ) {
			
			return 0;
		}
		//첫번째로 큰수, 두번째로 큰수
		int result1 =0;
		int result2 =0;
    //n번째 노드일때 다음 리스트 순차적 접근
		for(Node nd = node[n]; nd!=null; nd=nd.link ) {
      //방문 했으면 pass
			if(visited[nd.next])  continue;
      //방문하지 않았으면 방문체크 후 DFS 탐색
			visited[nd.next] = true;
      //쌓여온 지름에 더해준뒤 현재까지 지름이 큰지 본뒤 큰 반지름 반환
			int temp = DFS(nd.next)+nd.weight;
			if(result1<=temp) {
				if(result2<=result1) {
					result2 = result1;
				}
				result1 = temp;
			}else if(result1>temp && result2<temp) {
				result2 = temp;
			}
		}
		max_value = Math.max(max_value, result1+result2);
		
		return result1;
		
	}
}
