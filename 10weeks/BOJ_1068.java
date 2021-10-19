import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1068 {
	private static int N, leafCnt, startNode; //총 노드 수, 리프노드 수
	private static int[]parent; //부모 노드
	private static int delete; //삭제할 노드
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			parent[i] = Integer.parseInt(st.nextToken());
		}
		delete = Integer.parseInt(br.readLine()); 
				
		for(int i=0; i<N; i++) {
			if(parent[i] == -1) {
				startNode = i;
				break;
			}
		}
		
		parent[delete] = Integer.MAX_VALUE;

		solve();
		System.out.println(leafCnt);
	}
	
	private static void solve() {
		Queue<Integer>queue = new LinkedList<Integer>();
		
		queue.add(startNode);
		while(!queue.isEmpty()) {
			int node = queue.poll();
			if(node == delete) { //삭제할 노드는 스킵
				continue;
			}
			
			boolean isLeafNode = true;
			for(int i=0; i<N; i++) {
				if(parent[i] == node) { //리프노드가 아닌 경우
					queue.add(i);
					isLeafNode = false;
				}
			}
			
			if(isLeafNode) { //리프노드인 경우 카운트 증가
				leafCnt++;
			}
		}
	}

}
