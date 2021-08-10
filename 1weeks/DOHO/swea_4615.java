package SWEA;

//import java.util.Scanner;
//
//public class swea_4615 {
//    private static int[] dx = {-1,0,1,1,1,0,-1,-1};
//    private static int[] dy = {-1,-1,-1,0,1,1,1,0};
//    private static int N,M;
//
//    private static boolean isPossible(int[][] map, final int direction, final int yPos, final int xPos, final int stoneType) {
//        int newXPos = xPos, newYPos = yPos;
//        int count = 0;
//        while(true) {
//            newXPos += dx[direction];
//            newYPos += dy[direction];
//
//            if(newXPos < 0 || newXPos >= N || newYPos < 0 || newYPos >= N)
//                break;
//            if(map[newYPos][newXPos] == 0)
//                break;
//
//            if(map[newYPos][newXPos] == stoneType) {
//                if(count > 0)
//                    return true;
//                return false;
//            }
//
//            count++;
//        }
//
//        return false;
//    }
//
//    private static int setStone(int[][] map, final int direction, final int yPos, final int xPos, final int stoneType) {
//        int newXPos = xPos, newYPos = yPos;
//        int count = 0;
//        while(true) {
//            newXPos += dx[direction];
//            newYPos += dy[direction];
//
//            if(newXPos < 0 || newXPos >= N || newYPos < 0 || newYPos >= N)
//                break;
//
//            if(map[newYPos][newXPos] == stoneType)
//                break;
//            map[newYPos][newXPos] = stoneType;
//            count++;
//        }
//        return count;
//    }
//
//    public static void main(String args[]) throws Exception
//    {
//        Scanner sc = new Scanner(System.in);
//        int T;
//        T=sc.nextInt();
//
//        for(int test_case = 1; test_case <= T; test_case++)
//        {
//            int[] stoneCount = {0,2,2};	// black, white
//            N = sc.nextInt();
//            M = sc.nextInt();
//
//            int[][] map = new int[N][N];
//
//            // W B	 2 1
//            // B W   1 2
//            map[N/2-1][N/2-1] = 2;
//            map[N/2-1][N/2] = 1;
//            map[N/2][N/2-1] = 1;
//            map[N/2][N/2] = 2;
//
//            for(int i=0;i<M;i++) {
//                // x, y, stone
//                int xPos = sc.nextInt()-1;
//                int yPos = sc.nextInt()-1;
//                int stone = sc.nextInt();
//                if(stoneCount[stone] == 0)
//                    continue;
//                for(int j=0;j<8;j++) {
//                    if(isPossible(map,j,yPos,xPos,stone)) {
//                        if(map[yPos][xPos] != stone) {
//                            map[yPos][xPos]=stone;
//                            stoneCount[stone]++;
//                        }
//                        int result = setStone(map,j,yPos,xPos,stone);
//                        stoneCount[stone]+=result;
//                        if(stone == 1)
//                            stoneCount[2]-=result;
//                        else
//                            stoneCount[1]-=result;
//                    }
//                }
//            }
//            System.out.println("#"+test_case+" "+stoneCount[1]+" "+stoneCount[2]);
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4615 {
    private static int N;
    private static int[][] map;
    private static int[] dx = {-1,0,1,1,1,0,-1,-1};
    private static int[] dy = {-1,-1,-1,0,1,1,1,0};
    private static int recursive(final int dir, int yPos, final int xPos, final int type, final int count) {
        if(xPos < 0 || xPos >= N || yPos < 0 || yPos >= N) return 0;
        if(map[yPos][xPos] == 0) return 0;
        if (map[yPos][xPos] == type) return count;
        int retval = recursive(dir,yPos+dy[dir],xPos+dx[dir],type,count+1);
        if(retval > 0) {
            map[yPos][xPos] = type;
            return retval;
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case=1;test_case<=T;test_case++) {
            sb.append("#"+test_case+" ");
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            int mid = N/2;
            map[mid-1][mid-1] = map[mid][mid]=2;
            map[mid][mid-1] = map[mid-1][mid]=1;

            int[] stoneCount={0,2,2};
            for(int i=0;i<M;i++) {
                st = new StringTokenizer(br.readLine()," ");
                int xPos = Integer.parseInt(st.nextToken())-1;
                int yPos = Integer.parseInt(st.nextToken())-1;
                int type = Integer.parseInt(st.nextToken());
                map[yPos][xPos] = type;
                stoneCount[type]++;
                for(int dir=0;dir<8;dir++) {
                    int retval = recursive(dir,yPos+dy[dir],xPos+dx[dir],type,0);
                    if(retval != 0) {
                        stoneCount[type]+= retval; // 놓은 돌 1개 개수 추가
                        if(type == 1)
                            stoneCount[2] -= retval;
                        else
                            stoneCount[1] -= retval;
                    }
                }
            }
            sb.append(stoneCount[1]+" "+stoneCount[2]+'\n');
        }
        System.out.println(sb);
    }
}