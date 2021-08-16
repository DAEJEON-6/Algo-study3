package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] position = new int[26][2];
        for(int i=0;i<5;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<5;j++) {
                int index = Integer.parseInt(st.nextToken());
                position[index][0]=i;
                position[index][1]=j;
            }
        }

        // 세로 [1~25] count
        // 가로 [1~25] count
        // 대각선 ＼ / 순서 - 0,1번 인덱스
        int[][] counts = new int[3][26];

        int bingoCount = 0;
        int answer = 1;
        loop:
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<5;j++,answer++) {
                int index = Integer.parseInt(st.nextToken());
                if(++counts[0][position[index][0]] == 5)
                    bingoCount++;
                if(++counts[1][position[index][1]] == 5)
                    bingoCount++;
                if(position[index][0]==position[index][1]) {
                    if(++counts[2][0] == 5)
                        bingoCount++;
                }
                if(position[index][0]+position[index][1] == 4) {
                    if(++counts[2][1] == 5)
                        bingoCount++;
                }
                if(bingoCount >= 3)
                    break loop;
            }
        }
        System.out.println(answer);
    }
}
