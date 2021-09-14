import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main{
	static int R,C;
	static int[] cleaner1, cleaner2;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        int[][] dust = new int[R][C];
        
        for(int r=0; r<R; r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c=0; c<C; c++) {
        		dust[r][c] = Integer.parseInt(st.nextToken());
        		if(dust[r][c] == -1) {
        			cleaner1 = new int[] {r-1, c};
        			cleaner2 = new int[] {r, c};
        			dust[r][c] = 0;
        		}
        	}
        }
        
        
        
        while(T!=0) {
        	spread(dust);
        	refresh(dust);
        	T--;
        }
        
        int answer = 0;
        
        for(int r=0; r<R; r++) {
        	for(int c=0; c<C; c++) {
        		answer += dust[r][c];
        	}
        }
        
        bw.write(answer+"\n");
        
        bw.flush();
        bw.close();
        br.close();
	}
	
	static int[] search_c = {1,-1,0,0};
	static int[] search_r = {0,0,-1,1};
	
	public static void spread(int[][] dust) {
		int[][] add_dust = new int[R][C];
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(dust[r][c] == 0 || dust[r][c] ==-1) continue;
				
				int add = dust[r][c]/5;
				
				if(add == 0) continue;
				
				for(int s=0; s<4; s++) {
					int new_c = c+search_c[s];
					int new_r = r+search_r[s];
					
					if(new_c<0 || new_r<0 || new_c>=C || new_r>=R || (new_r==cleaner1[0] && new_c == cleaner1[1]) || (new_r==cleaner2[0] && new_c == cleaner2[1])) {
						continue;
					}
					
					add_dust[r][c] -= add;
					add_dust[new_r][new_c] += add;
				}
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				dust[r][c] += add_dust[r][c];
			}
		}
	}
	
	public static void refresh(int[][] dust) {
		int y = cleaner1[0];
		int x = cleaner1[1];
		
		int[] move_y = {-1,0,1,0};
		int[] move_x = {0,1,0,-1};
		
		int curr = 0;
		
		while(curr<4) {
			int new_y = y+move_y[curr];
			int new_x = x+move_x[curr];
			
			if(new_y<0 || new_x>=C || new_y>cleaner1[0] || new_x<0) {
				curr++;
				continue;
			}
			
			int temp = dust[y][x];
			dust[y][x] = dust[new_y][new_x];
			dust[new_y][new_x] = temp;
			
			y = new_y;
			x = new_x;
		}
		
		dust[cleaner1[0]][cleaner1[1]] = 0; 
		dust[cleaner1[0]][cleaner1[1]+1] = 0; 
		
		//클리너2 동작
		
		y = cleaner2[0];
		x = cleaner2[1];
		
		move_y = new int[] {1,0,-1,0};
		move_x = new int[] {0,1,0,-1};
		
		curr = 0;
		
		while(curr<4) {
			int new_y = y+move_y[curr];
			int new_x = x+move_x[curr];
			
			if(new_y<cleaner2[0] || new_x>=C || new_x<0 || new_y>=R) {
				curr++;
				continue;
			}
			
			int temp = dust[y][x];
			dust[y][x] = dust[new_y][new_x];
			dust[new_y][new_x] = temp;
			
			y = new_y;
			x = new_x;
		}
		
		dust[cleaner2[0]][cleaner2[1]] = 0;
		dust[cleaner2[0]][cleaner2[1]+1] = 0;
	}
}
