import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * [백준] 연구소 3
 *  출처 : https://www.acmicpc.net/problem/17142
 *  풀이 기법 : 구현
 */

public class Main{
	static int M,N;
	static int[][] map;
	static Stack<int[]> virus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        virus = new Stack<int[]>();
        for(int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<N; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        //바이러스 고르자
        choice(0,0,0);
        
        bw.write(((result==Integer.MAX_VALUE)?-1:result)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
    static int result = Integer.MAX_VALUE;
	private static void choice(int y, int x, int n) {
		
		if(n==M) {
			result = Math.min(bfs(),result);
		}
		
		
		if(x==N) {
			x=0;
			y++;
		}
		
		while(y<N) {
			if(map[y][x]==2) {
				map[y][x] = 3;
				virus.add(new int[] {y,x});
				choice(y,x+1,n+1);
				virus.pop();
				map[y][x] = 2;
			}
			
			x++;
			if(x==N) {
				x=0;
				y++;
			}
		}
	
	}
	static int[] my = {1,-1,0,0};
	static int[] mx = {0,0,-1,1};
	private static int bfs() {
		int[][] temp = new int[N][N];
		//지도 복제 
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		Queue<int[]> que = new LinkedList<int[]>();
		
		for(int i=0; i<M; i++) {
			que.add(virus.get(i));
		}
		
		int result = 0;
		
		boolean check = true;
		while(!que.isEmpty()) {
			int size = que.size();
			check = true;
			//바이러스 모두 퍼졌는지 확인
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(temp[i][j]==0) {
						check = false;
						break;
					}
				}
				if(!check) break;
			}
			if(check) break;
			while(size-->0) {
				int[] curr = que.poll();
				int y = curr[0];
				int x = curr[1];
				
				for(int i=0; i<4; i++) {
					int ny = y+my[i];
					int nx = x+mx[i];
					
					if(ny<0 || ny>=N || nx<0 || nx>=N || temp[ny][nx]==3 || temp[ny][nx]==1) continue;
					
					temp[ny][nx] = 1;
					que.add(new int[] {ny,nx});
				}
			}
			result++;

		}
		
		return (check)?result:Integer.MAX_VALUE;
	}
}
