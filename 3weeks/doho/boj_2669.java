package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2669 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] map = new boolean[100][100];

        for(int i=0;i<4;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sx = Integer.parseInt(st.nextToken())-1;
            int sy = Integer.parseInt(st.nextToken())-1;
            int dx = Integer.parseInt(st.nextToken())-1;
            int dy = Integer.parseInt(st.nextToken())-1;

            for(int j=sy;j<dy;j++) {
                for(int k=sx;k<dx;k++)
                    map[j][k] = true;
            }
        }

        int answer = 0;
        for(int i=0;i<100;i++) {
            for(int j=0;j<100;j++)
                if(map[i][j]) answer++;
        }

        System.out.println(answer);
    }
}
