import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
백준 16946 벽 부수고 이동하기 4 입니다 .
벽 부순 개수 별로 방문 배열을 따로 생성해주었습니다. 
- 사용 알고리즘 : DFS, DP(?)
*/
public class Main{
	static int[][] map,map2;
	static int N,M,number;
	static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        //세로 가로
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        //구역 표시할 2차원 배열
        map2 = new int[N][M];
        for(int i=0; i<N; i++) {
        	String str = br.readLine();
        	for(int j=0; j<M; j++) {
        		map[i][j] = str.charAt(j)-'0';
        		
        		if(map[i][j] == 1) map[i][j] = -1;
        	}
        }
        //방문 배열
        visited = new boolean[N][M];
        number = 0;
        //갈수있는 구역 갯수 표시
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(map[i][j] == 0 && !visited[i][j]) {
        			number++;
        			visited[i][j] = true;
        			map[i][j] = able(i,j);
        		}
        	}
        }
        
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(map[i][j] >= 0 && !visited[i][j]) {
        			dfs(i,j,map[i][j]);
        		}
        	}
        }
        
        int[][] result = new int[N][M];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		if(map[i][j] == -1) {
        			//이미 합친 구역인지 확인할 배열
        			int[] check = new int[4];
        	    	for(int k=0; k<4; k++) {
        	    		int new_y = i + move_y[k];
        	    		int new_x = j + move_x[k];
        	    		
        	    		if(new_y<0 || new_y>=N || new_x<0 || new_x>=M || map2[new_y][new_x]==0) continue;
        	    		//넣을수 있는지?
        	    		boolean pos = true;
        	    		
        	    		for(int l=0; l<4; l++) {
        	    			if(check[l] == map2[new_y][new_x]) {
        	    				pos = false;
        	    				break;
        	    			}
        	    		}
        	    		
        	    		if(pos) {
        	    			result[i][j] += map[new_y][new_x];
        	    			check[k] = map2[new_y][new_x];
        	    		}
        	    	}
        	    	
        	    	sb.append((result[i][j]+1)%10);
        		}else {
        			sb.append(0);
        		}
        	}
        	sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    
    static int[] move_y = {-1,0,1,0};
    static int[] move_x = {0,-1,0,1};
    public static int able(int y, int x) {
    	
    	int result = 1;
    	
    	for(int i=0; i<4; i++) {
    		int new_y = y + move_y[i];
    		int new_x = x + move_x[i];
    		
    		if(new_y<0 || new_y>=N || new_x<0 || new_x>=M || visited[new_y][new_x]) continue;
    		
    		if(map[new_y][new_x]==0) {
    			visited[new_y][new_x] = true;
    			result += able(new_y,new_x);
    		}
    	}
    	//구역 번호
    	map2[y][x] = number; 
    	
    	return result;
    }
    
    public static void dfs(int y, int x, int num) {
    	visited[y][x] = true;
    	map[y][x] = num;
    	
    	for(int i=0; i<4; i++) {
    		int new_y = y + move_y[i];
    		int new_x = x + move_x[i];
    		
    		if(new_y<0 || new_y>=N || new_x<0 || new_x>=M || visited[new_y][new_x]) continue;
    		
    		if(map[new_y][new_x]==0) {
    			visited[new_y][new_x] = true;
    			dfs(new_y,new_x,num);
    		}
    	}
    }
    
}
