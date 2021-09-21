import java.util.Scanner;

public class BOJ_14938 {

	static int N, M, R;
	static int[]items;
	static int[][]adjMatrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //지역 수
		M = sc.nextInt(); //수색범위
		R = sc.nextInt(); //간선 수
		items = new int[N+1];
		int INF = 1000000;

		for(int i=1; i<=N; i++) { //지역 별 아이템 개수
			items[i] = sc.nextInt();
		}

		adjMatrix = new int[N+1][N+1]; //인접리스트
	
		for(int i=0; i<R; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			adjMatrix[from][to] = weight; //양방향 간선으로 처리
			adjMatrix[to][from] = weight;
		}
		
		for(int i=1; i<=N; i++) { //경유지 없이 각 노드별 다른 모든 노드까지 가는데 걸리는 비용
			for(int j=1; j<=N; j++) {
				if(adjMatrix[i][j] == 0 && i!=j) {
					adjMatrix[i][j] = INF;
				}
			}
		}

		floydWarshall();
		System.out.println(calcNumItems());
	}
	
	private static int calcNumItems() { //각 지역을 시작점으로 최대 아이템 개수 구하기
		int maxItems = 0;
		for(int i=1; i<=N; i++) {
			int numItems = 0;
			for(int j=1; j<=N; j++) {
				if(adjMatrix[i][j] <= M) { //수색 범위보다 작으면 해당 지역의 아이템 획득
					numItems += items[j];
				}
			}
			maxItems = Math.max(maxItems, numItems);
		}
		return maxItems;
	}
	
	private static void floydWarshall() { //경유지를 거쳐서 각 지역별  최소 방문 가능거리 구하기
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k]+adjMatrix[k][j]);
				}
			}
		}
	}	
}