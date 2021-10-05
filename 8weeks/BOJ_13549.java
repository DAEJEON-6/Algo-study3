import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {
	
	private static class Point{
		int num;
		int dist;
		public Point(int num, int dist) {
			super();
			this.num = num;
			this.dist = dist;
		}
	}
	private static int N, K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int time = bfs();
		System.out.println(time);
	}

	private static int bfs() {
		Queue<Point>queue = new LinkedList<Point>();
		boolean[]visited = new boolean[100001];
		visited[N] = true; //수빈이의 처음 시작위치 방문 표시
		queue.offer(new Point(N, 0));

		while(!queue.isEmpty()) {
			Point cur = queue.poll();

			if(cur.num==K) { //동생의 위치 도착
				return cur.dist;
			}

			int a = cur.num-1; //왼쪽 한 칸 이동
			int b = cur.num+1; //오른쪽 한 칸 이동
			int c = cur.num*2; //순간이동

			if(c>=0 && c<=100000 && !visited[c]) { //순간이동한 경우를 가장 먼저 큐에 넣어줌 (시간이 더 적게 걸릴 수 있기때문에)
				visited[c] = true;
				queue.offer(new Point(c, cur.dist));
			}
			if(a>=0 && a<=100000 && !visited[a]) {
				visited[a] = true;
				queue.offer(new Point(a, cur.dist+1));
			}
			if(b>=0 && b<=100000 && !visited[b]) {
				visited[b] = true;
				queue.offer(new Point(b, cur.dist+1));
			}
			
		}
		return -1;
	}

}
