package SWEA;

//import java.util.Scanner;
//
//public class swea_2805 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T;
//        T=sc.nextInt();
//
//        for(int test_case = 1; test_case <= T; test_case++)
//        {
//            int N = sc.nextInt();
//
//            int[][] map = new int[N][N];
//            for(int i=0;i<N;i++) {
//                String str = sc.next();
//                for(int j=0;j<N;j++) {
//                    map[i][j] = Character.getNumericValue(str.charAt(j));
//                }
//            }
//
//            int sum = 0;
//            for(int i=0;i<N;i++) {
//                sum += map[N/2][i];
//            }
//
//            int yIndex = N/2-1;
//            int xIndex = 1;
//            int count = N-2;
//            while(yIndex >= 0) {
//                for(int i=0;i<count;i++) {
//                    sum += map[yIndex][xIndex+i];
//                }
//                yIndex--;
//                xIndex++;
//                count -= 2;
//            }
//
//            yIndex = N/2+1;
//            xIndex = 1;
//            count = N-2;
//            while(yIndex < N) {
//                for(int i=0;i<count;i++) {
//                    sum += map[yIndex][xIndex+i];
//                }
//                yIndex++;
//                xIndex++;
//                count -= 2;
//            }
//            System.out.println("#"+test_case+" "+sum);
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_2805 {
    private static int sum(final int N, int[][] map, final int yPos, final int count) {
        int sum = 0;
        for(int i=count;i<(N-count);i++)
            sum += map[yPos][i];
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case<=T;test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for(int i=0;i<N;i++) {
                map[i] = Arrays.stream(br.readLine().split(""))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            }

            int yPivot = N/2;
            int answer = sum(N,map,yPivot,0);
            for(int i=1;(yPivot+i) < N ; i++) {
                answer += sum(N,map,yPivot-i,i);
                answer += sum(N,map,yPivot+i,i);
            }
            sb.append("#"+test_case+' '+answer+'\n');
        }
        System.out.println(sb);
    }
}