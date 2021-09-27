package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_17070 {
    private static int[][] map;
    private static int N;
    private static int answer = 0;

    // 0 : 가로, 1 : 대각선, 2: 세로
    private static int[][] dir = {{1,1,0},{1,1,1},{0,1,1}};
    private static int[] dx = {1,1,0};
    private static int[] dy = {0,1,1};

    private static boolean isPossible(final int yIdx, final int xIdx) {
        if(yIdx < 0 || yIdx >= N || xIdx<0 || xIdx>=N)
            return false;
        return true;
    }

    private static void DFS(final int yIdx, final int xIdx, final int prevDir) {
        if(yIdx == N-1 && xIdx == N-1) {
            answer++;
            return;
        }
        for(int i=0;i<3;i++) {
            if (dir[prevDir][i] == 0) continue;
            int newX = xIdx + dx[i];
            int newY = yIdx + dy[i];
            if (!isPossible(newY, newX)) continue;
            if (map[newY][newX] == 1) continue;
            if (i == 1 && (map[newY - 1][newX] == 1 || map[newY][newX - 1] == 1)) continue;
            DFS(newY, newX, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][];
        for(int i=0;i<N;i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        DFS(0,1,0);
        System.out.println(answer);
    }
}
