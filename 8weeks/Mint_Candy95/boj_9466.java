import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	static int[] arr;
	static boolean[] maked,visited,wvisited;
	static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-->0) {
        	n = Integer.parseInt(br.readLine());
        	
        	arr = new int[n+1];
        	maked = new boolean[n+1];
        	wvisited = new boolean[n+1];
        	
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	for(int i=1; i<n+1; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	int result = 0;
        	for(int i=1; i<=n; i++) {
        		if(wvisited[i] && !maked[i]) continue;
        		if(maked[i]) continue;

        		visited = new boolean[n+1];
        		makeTeam(i,i);
        		
        		if(!maked[i]) result++;
        	}
        	
        	bw.write(result+"\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
	private static int makeTeam(int start, int num) {
		if(wvisited[num] && !maked[num]) return 0;
		
		if(maked[num]) return 0;
		
		if(start == arr[num]) {
			maked[num] = true;
			return 987654321;
		}

		int result = 0;
		wvisited[num] = true;
		if(visited[arr[num]] && arr[num]==start) {
			maked[num] = true;
			return 987654321;
		}else if(visited[arr[num]] && arr[num]!=start) {
			visited = new boolean[n+1];
			makeTeam(num,num);
			return 0;
		}

		if(!visited[arr[num]]) {
			visited[num] = true;
			result = makeTeam(start,arr[num]);
			if(result!=0) maked[num] = true;
			return result;
		}
		
		return result;
	}

}

