import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * Author : YoungSeo Jeon
 * Date : 2021-09-12
 * Description : 백준 17144
 */

public class Main{
	static int R,C;  //세로 가로
	static int[] cleaner1, cleaner2; //공기청정기 위, 아래 위치 저장
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        //R,C,T 입력 세로, 가로, 시간
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        //먼지 배열
        int[][] dust = new int[R][C];
        //입력
        for(int r=0; r<R; r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c=0; c<C; c++) {
        		dust[r][c] = Integer.parseInt(st.nextToken());
        		if(dust[r][c] == -1) { //클리너 위치 입력받고 그 자리 0 으로 만든다. 어차피 위아래 붙어잇으므로 마지막꺼만 유효
        			cleaner1 = new int[] {r-1, c};
        			cleaner2 = new int[] {r, c};
        			dust[r][c] = 0;
        		}
        	}
        }
        
        
        //T초만큼 반복
        while(T!=0) {
        	spread(dust); //먼지 퍼짐
        	refresh(dust); //공기청정기 작동
        	T--; //시간 줄어듬
        }
        //정답
        int answer = 0;
        //먼지 count
        for(int r=0; r<R; r++) {
        	for(int c=0; c<C; c++) {
        		answer += dust[r][c];
        	}
        }
        //출력
        bw.write(answer+"\n");
        
        bw.flush();
        bw.close();
        br.close();
	}
	//먼지를 퍼뜨릴 곳
	static int[] search_c = {1,-1,0,0};
	static int[] search_r = {0,0,-1,1};
	
  //먼지가 퍼진다.
	public static void spread(int[][] dust) {
    //초기 먼지의 양만 유효하다. 따라서 옮겨질 먼지를 임시 배열에 저장해준다.
		int[][] add_dust = new int[R][C];
		//먼지를 찾는다
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(dust[r][c] == 0 || dust[r][c] ==-1) continue;
				//흩어질 먼지의 양
				int add = dust[r][c]/5;
				//0이면 의미 없으므로 다음 칸으로
				if(add == 0) continue;
				//사방에 먼지를 퍼뜨린다
				for(int s=0; s<4; s++) {
					int new_c = c+search_c[s];
					int new_r = r+search_r[s];
					// 범위를 벗어나거나 공기청정기면 퍼뜨리지 못한다.
					if(new_c<0 || new_r<0 || new_c>=C || new_r>=R || (new_r==cleaner1[0] && new_c == cleaner1[1]) || (new_r==cleaner2[0] && new_c == cleaner2[1])) {
						continue;
					}
					//add만큼 먼지를 옮겨준다.
					add_dust[r][c] -= add;
					add_dust[new_r][new_c] += add;
				}
			}
		}
		//옮겨질 먼지를 원래 배열에 더해준다.
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				dust[r][c] += add_dust[r][c];
			}
		}
	}
	//공기 청정기 작동
	public static void refresh(int[][] dust) {
    //클리너 1 
    //클리너1의 위치
		int y = cleaner1[0];
		int x = cleaner1[1];
		//클리너 공기의 작동 방향
		int[] move_y = {-1,0,1,0};
		int[] move_x = {0,1,0,-1};
		//작동 방향 표시
		int curr = 0;
		//한바퀴 돌면 끝
		while(curr<4) {
			int new_y = y+move_y[curr];
			int new_x = x+move_x[curr];
			//범위 벗어나면 방향 전환
			if(new_y<0 || new_x>=C || new_y>cleaner1[0] || new_x<0) {
				curr++;
				continue;
			}
			//교환
			int temp = dust[y][x];
			dust[y][x] = dust[new_y][new_x];
			dust[new_y][new_x] = temp;
			//다음 위치로
			y = new_y;
			x = new_x;
		}
		//공기청정기의 위치와, 공기청정기에서 나온 공기는 먼지가 0
		dust[cleaner1[0]][cleaner1[1]] = 0; 
		dust[cleaner1[0]][cleaner1[1]+1] = 0; 
		
		//클리너2 동작--- 클리너1 에서 방향만 바꿔주면 된다.
		
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
