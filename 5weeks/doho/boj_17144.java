package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17144 {
    private static int R,C,T;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};
    private static int[][] cycleDir = {{0,3,1,2}, {1,3,0,2}};
    private static int[][] airCleaner;
    private static mapNode[][] map;

    private static int diffusion(final int yIndex,final int xIndex, final int dust) {
        int count = 0;
        for(int i=0;i<4;i++) {
            int newX = xIndex + dx[i];
            int newY = yIndex + dy[i];
            if(newX < 0 || newX >= C || newY < 0 || newY >= R) continue;
            if(map[newY][newX].dust == -1) continue;
            count++;
            map[newY][newX].setAdded(dust);
        }
        return count;
    }

    private static void cycle(int type) {

        int yPos = airCleaner[type][0];
        int xPos = airCleaner[type][1];

        for(int i=0;i<4;i++) {
            while(true) {
                int newX = xPos + dx[cycleDir[type][i]];
                int newY = yPos + dy[cycleDir[type][i]];

                if(newX < 0 || newX >= C || newY < 0 || newY >= R)
                    break;
                if(newX == airCleaner[type][1] && newY == airCleaner[type][0]) {
                    map[yPos][xPos] = new mapNode(0);
                    break;
                }


                if(map[yPos][xPos].getDust() != -1) {
                    map[yPos][xPos] = map[newY][newX];
                }
                yPos = newY;
                xPos = newX;
                if((cycleDir[type][i] == 0 || cycleDir[type][i] == 1) && yPos == airCleaner[type][0])
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());


        map = new mapNode[R][C];

        airCleaner = new int[2][2];
        int cleanerIndex = 0;
        for(int i=0;i<R;i++) {
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j<C;j++) {
                map[i][j] = new mapNode(Integer.parseInt(st.nextToken()));
                if(map[i][j].dust == -1) {
                    airCleaner[cleanerIndex][0] = i;
                    airCleaner[cleanerIndex][1] = j;
                    cleanerIndex++;
                }
            }
        }

        for(int count = 0;count < T;count++) {
            // diffusion
            for(int i=0;i<R;i++) {
                for(int j=0;j<C;j++) {
                    if(map[i][j].dust > 0)
                        map[i][j].setDust(diffusion(i,j,map[i][j].getDiffisionAmount()));
                }
            }

            // merge
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j].complete();
                }
            }

            // cycle
            for(int i=0;i<2;i++)
                cycle(i);
        }

        int sum = 0;
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(map[i][j].dust > 0)
                    sum+=map[i][j].dust;
            }
        }

        System.out.println(sum);
    }

    static class mapNode {
        private int dust;
        private int added;

        public mapNode(int dust) {
            this.dust = dust;
        }

        public void complete() {
            dust += added;
            added = 0;
        }

        public int getDust() {
            return dust;
        }

        public int getDiffisionAmount() {
            if(dust == -1)
                return 0;
            return dust/5;
        }

        public void setDust(int count) {
            dust -= (dust/5)*count;
        }

        public void setAdded(int dust) {
            added += dust;
        }
    }
}
