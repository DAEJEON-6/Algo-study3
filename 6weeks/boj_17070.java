import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //배열 크기 입력
        N = Integer.parseInt(br.readLine());
        //배열 생성
        arr = new int[N][N];

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(func(0,1,0)+"\n");

        bw.flush();
        bw.close();
        br.close();
    }

    //y, x, 현재 모양 가로,세로,대각
    public static int func(int y, int x, int dir){
        if(x==N-1 && y==N-1){
            return 1;
        }

        int result = 0;
        //오른쪽
        if(dir != 1 && x+1 < N && arr[y][x+1]!= 1){
            result += func(y, x+1, 0);
        }
        //아래
        if(dir != 0 && y+1 < N && arr[y+1][x] != 1){
            result += func(y+1,x,1);
        }
        //대각
        if(x+1<N && y+1<N && arr[y+1][x+1]!=1&&arr[y+1][x]!=1&&arr[y][x+1]!=1){
            result += func(y+1,x+1,2);
        }

        return result;
    }

}
