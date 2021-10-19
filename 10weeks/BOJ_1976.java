import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1976 {
	private static int N, M;
	private static int[]cities;
	private static int[][]adjList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); //총 도시 수 
		M = Integer.parseInt(br.readLine()); //여행 계획에 속한 도시 수
		StringTokenizer st;
		cities = new int[M+1]; //여행 계획에 속한 도시들
		adjList = new int[N+1][N+1];
		for(int i=1; i<=N; i++) { //전체 도시들 간 연결 관계
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				adjList[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++) {
			cities[i] = Integer.parseInt(st.nextToken());
		}
		
		bfs();
	}
	
	private static void bfs() {
        Queue<Integer>queue = new LinkedList<Integer>();
        boolean[]visited = new boolean[N+1];
        int index = 1; //방문할 도시의 인덱스
        int targetCity = cities[index]; //방문할 도시
        int visitCnt = 0;
        
        queue.add(targetCity);
        while(!queue.isEmpty()) {
            int city = queue.poll();
            visited[city] = true;
                    
            for(int i=1; i<=N; i++) { //이웃하는 도시에 다음 방문할 도시가 있는지 확인
                int neighbor = adjList[city][i];
                if((neighbor==1 && !visited[i])||(city==i && adjList[i][i]==1)) { //방문하지 않은 방문 가능한 도시이거나 자기 자신인 경우
                    queue.add(i);
                }
            }

            if(city == targetCity) { //원하는 도시 방문
                visitCnt++;
                if(visitCnt == M) { //원하는 도시 모두 방문
                    break;
                }
                index++; //다음 도시를 방문하기 위해 인덱스 증가
                Arrays.fill(visited, false); //모든 도시에 대해 방문처리 초기화 (같은 도시 중복 방문 가능)
                targetCity = cities[index];
                queue.clear();//낭비되는게 너무 많은거 같아요
                queue.add(city);
            }
        }
        
        if(visitCnt < M) { //순서대로 원하는 도시 방문하지 못함
            System.out.println("NO");
        }else { //순서대로 원하는 도시 모두 방문
            System.out.println("YES");
        }
    }
}
