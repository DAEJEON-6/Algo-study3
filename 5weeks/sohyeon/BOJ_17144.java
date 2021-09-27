package algo.study.boj.gold;

import java.util.*;
import java.io.*;

public class BOJ_17144 {
    static int R, C, T, map[][];
    static int[] dx1 = {-1, 0, 1, 0}, dy1 = {0, 1, 0, -1};    //반시계방향 이동
    static int[] dx2 = {1, 0, -1, 0}, dy2 = {0, 1, 0, -1};    //시계방향 이동
    static ArrayList<Integer> airCleaner;    //공기청정기 x좌표
    static ArrayList<Node> loc;    //먼지 정보 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        airCleaner = new ArrayList<>();
        loc = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) airCleaner.add(i);    //공기청정기 x좌표 추가
                else if (map[i][j] != 0) loc.add(new Node(i, j, map[i][j]));    //먼지 정보 추가
            }
        }

        for (int i = 0; i < T; i++) {
            spread();    //미세먼지 확산
            air();        //공기청정기 작동
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) continue;
                result += map[i][j];
            }
        }

        System.out.println(result);
    }

    static void spread() {
        int[][] temp = new int[R][C];

        for (Node node : loc) {    //먼지 위치만 탐색
            int cnt = 0, mount = node.dust / 5;    //확산된 방향의 개수, 확산되는 양
            for (int k = 0; k < 4; k++) {
                int xx = node.x + dx1[k];
                int yy = node.y + dy1[k];
                if (xx < 0 || xx >= R || yy < 0 || yy >= C || map[xx][yy] == -1) continue;
                temp[xx][yy] += mount;
                cnt++;
            }
            temp[node.x][node.y] += node.dust - mount * cnt;
        }
        // 확산된 결과 맵에 복사
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[i][j];
            }
        }
        map[airCleaner.get(0)][0] = map[airCleaner.get(1)][0] = -1;    //공기청정기 위치 복원
    }

    static void air() {
        //공기청정기 위쪽
        int stop = airCleaner.get(1);    //공기청정기가 있는 행을 기준으로 순환
        int x = airCleaner.get(0);    //위쪽 공기청정기 좌표
        int y = 0;
        //반시계반향으로 순환, 상우하좌로 탐색
        for (int i = 0; i < 4; i++) {
            while (true) {
                int xx = x + dx1[i];
                int yy = y + dy1[i];
                if (xx < 0 || xx >= stop || yy < 0 || yy >= C || map[xx][yy] == -1) break;
                if (map[x][y] == -1) {
                    map[xx][yy] = 0;
                } else {
                    map[x][y] = map[xx][yy];
                    map[xx][yy] = 0;
                }
                x = xx;
                y = yy;
            }
        }
        //공기청정기 아래쪽
        x = airCleaner.get(1);    //아래쪽 공기청정기 좌표
        y = 0;
        //시계반향으로 순환, 하우상좌로 탐색
        for (int i = 0; i < 4; i++) {
            while (true) {
                int xx = x + dx2[i];
                int yy = y + dy2[i];
                if (xx < stop || xx >= R || yy < 0 || yy >= C || map[xx][yy] == -1) break;
                if (map[x][y] == -1) {
                    map[xx][yy] = 0;
                } else {
                    map[x][y] = map[xx][yy];
                    map[xx][yy] = 0;
                }
                x = xx;
                y = yy;
            }
        }
        //최종 맵의 먼지를 리스트에 넣어주기
        loc.clear();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) loc.add(new Node(i, j, map[i][j]));
            }
        }
    }

    static class Node {
        int x, y, dust;    //좌표, 미세먼지양
        public Node(int x, int y, int dust) {
            this.x = x;
            this.y = y;
            this.dust = dust;
        }
    }
}