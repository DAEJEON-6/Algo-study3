import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력값
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        //아이템 수와 거리 저장할 배열
        int[] item = new int[n+1];
        int[][] locate = new int[n+1][n+1];

        //최댓값으로 초기화
        for(int i=0; i<=n; i++){
            Arrays.fill(locate[i], 987654321);
        }
        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            //출발 도착 거리
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            locate[a][b] = c;
            locate[b][a] = c;
        }
        //플로이드-와샬
        for(int t=1; t<=n; t++){
            for(int i=1; i<=n; i++){
                if(t==i) continue;
                for(int j=0; j<=n; j++){
                    if(j==i || j==t) continue;

                    locate[i][j] = Math.min(locate[i][j], locate[i][t]+locate[t][j]);
                }
            }
        }
      
       //갈수있는 지역의 아이템수만 더해서 비교해준다
        int result = 0;
        for(int i=1; i<=n; i++){
            int value = item[i];
            for(int j=1; j<=n; j++){
                if(locate[i][j] == 987654321 || locate[i][j] >m) continue;

                value += item[j];
            }

            result = Math.max(result, value);
        }

        bw.write(result+"\n");


        bw.flush();
        bw.close();
        br.close();
    }

}
