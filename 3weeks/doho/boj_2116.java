package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2116 {
    private static int N;
    private static int answer;
    private static int[] pair = {5,3,4,1,2,0};
    private static int[][] dice;

    private static void stack(int btmValue, int level, int sum) {
        if(level == N) {
            answer = Math.max(answer,sum);
            return;
        }
        int btmIndex = 0;
        for(int i=0;i<6;i++) {
            if (dice[level][i] == btmValue) {
                btmIndex = i;
                break;
            }
        }
        int max = 0;
        for(int i=0;i<6;i++) {
            if( i == btmIndex || i == pair[btmIndex]) continue;
            max = Math.max(max,dice[level][i]);
        }
        stack(dice[level][pair[btmIndex]],level+1,sum+max);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dice = new int[N][6];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<6;j++)
                dice[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<6;i++) {
            stack(dice[0][i],0,0);
        }

        System.out.println(answer);
    }
}
