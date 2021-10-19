import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
백준 1976 문제 
플로이드-와샬을 적용하면 간단하게 풀립니다.
주의할점 : 자기 자신으로 가는 것도 가능하다.
*/


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] able = new int[N][N]; 
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				able[i][j] = Integer.parseInt(st.nextToken());
				if(i==j) able[i][j] = 1;
			}
		}
		
		//플로이드 와샬 
		for(int k=0; k<N; k++) {
			for(int i=0; i<N; i++) {
				if(k==i) continue;
				for(int j=0; j<N; j++) {
					if(j==k || j==i) continue;
					
					if(able[i][k]+able[k][j]==2) {
						able[i][j] = 1;
					}
				}
			}
		}
		
		boolean result = true;
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken());
		int end = 0;
		for(int i=0; i<M-1; i++) {
			end = Integer.parseInt(st.nextToken());
			
			if(able[start-1][end-1]==0) {
				result = false;
				break;
			}
			start = end;
		}
		
		if(result) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
