package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2564 {
    private static int N,M,K;
    private static int answer = 0;

    private static void setPosition(int[] position, int dir, int dis) {
        switch (dir) {
            case 1:
                position[0] = 0;
                position[1] = dis;
                break;
            case 2:
                position[0] = N-1;
                position[1] = dis;
                break;
            case 3:
                position[0] = dis;
                position[1] = 0;
                break;
            case 4:
                position[0] = dis;
                position[1] = M-1;
                break;
        }
    }

    private static void BFS(int[][] map, int yPos, int xPos) {
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,yPos,xPos});
        map[yPos][xPos] = 0;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();   // cost, yPos, xPos;
            for(int i=0;i<4;i++) {
                int newY = now[1] + dy[i];
                int newX = now[2] + dx[i];
                int newCost = now[0] + 1;
                if(newX < 0 || newX >= M || newY < 0 || newY >= N) continue;
                if(map[newY][newX] <= newCost) continue;
                map[newY][newX] = newCost;
                queue.add(new int[] {newCost,newY,newX});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken())+1;
        N = Integer.parseInt(st.nextToken())+1;

        int[][] map = new int[N][M];
        for(int i=0;i<N;i++) {
            if(i == 0 || i == N-1) {
                for (int j = 0; j < M; j++)
                    map[i][j] = Integer.MAX_VALUE;
            } else {
                map[i][0]=map[i][M-1]=Integer.MAX_VALUE;
            }
        }

        K = Integer.parseInt(br.readLine());
        int[][] position = new int[K][2];
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine()," ");
            setPosition(position[i],Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine()," ");
        int[] manPosition = new int[2];
        setPosition(manPosition,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        BFS(map, manPosition[0],manPosition[1]);

        for(int i=0;i<K;i++)
            answer += map[position[i][0]][position[i][1]];
        System.out.println(answer);
    }
}
