import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];

        if(N>M) {
        	System.out.println(N-M);
        	return;
        }
        
        if(N==M) {
        	System.out.println(0);
        	return;
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(N);
        visited[N] = true;
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();

            while(size!=0){
                int curr = queue.poll();
                size--;

                if(curr == M){
                    System.out.println(count);
                    return;
                }

                int temp1 = curr-1;
                int temp2 = curr+1;
                int temp3 = curr*2;
                
                while(true) {
                	if(temp3 == M){
                        System.out.println(count);
                        return;
                    }
	                if(temp3<=100000 && !visited[temp3]){
	                    visited[temp3] = true;
	                }
                    if(temp2<=100000 && !visited[temp2]){
                        queue.add(temp2);
                        visited[temp2] = true;
                    }
                	if(temp1>=0 && temp1<=100000 && !visited[temp1]){
                        queue.add(temp1);
                        visited[temp1] = true;
                    }
                	
	                temp1 = temp3-1;
	                temp2 = temp3+1;
	                temp3 = temp3*2;

	                if(temp1>100000 || temp3<=0) break;
                }
            }
            count++;
        }
        br.close();
    }
}