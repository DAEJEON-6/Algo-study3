package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14938 {
    private static final int MAX = 1501;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        int[] costs = new int[N];
        for(int i=0;i<N;i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int[][] paths = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(i==j)
                    paths[i][j] = 0;
                else
                    paths[i][j] = MAX;
            }
        }
        for(int i=0;i<R;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int source = Integer.parseInt(st.nextToken())-1;
            int dest = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            paths[source][dest] = cost;
            paths[dest][source] = cost;
        }

        for(int k=0;k<N;k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(paths[i][k] + paths[k][j] < paths[i][j])
                        paths[i][j] = paths[i][k] + paths[k][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int sum = costs[i];
            for (int j = 0; j < N; j++) {
                if(paths[i][j] > 0 && paths[i][j] <= M)
                    sum += costs[j];
            }
            answer = Math.max(sum,answer);
        }
        System.out.println(answer);
    }
}
