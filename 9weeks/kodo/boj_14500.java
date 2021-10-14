package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [백준] 테트로미노
 *  출처 : https://www.acmicpc.net/problem/14500
 *  풀이 기법 : Implementation
 */

public class boj_14500 {
  private static // 종류, 방향, 블럭
  int[][][][] tetromino = {
    // ㅡ 블럭
    {
      // 첫번째 방향
      { {0,0},{0,1},{0,2},{0,3} },
      // 두번째 방향
      { {0,0},{1,0},{2,0},{3,0} },
      // 세번째 방향 (X)
      { {0,0},{0,0},{0,0},{0,0} },
      // 네번째 방향 (X)
      { {0,0},{0,0},{0,0},{0,0} }
    },
    // ㅁ 블럭
    {
      // 첫번째 방향
      { {0,0},{0,1},{1,0},{1,1} },
      // 두번째 방향 (X)
      { {0,0},{0,0},{0,0},{0,0} },
      // 세번째 방향 (X)
      { {0,0},{0,0},{0,0},{0,0} },
      // 네번째 방향 (X)
      { {0,0},{0,0},{0,0},{0,0} }
    },
    // ㄴ 블럭
    {
      // 첫번째 방향
      { {0,0},{1,0},{2,0},{2,1} },
      // 두번째 방향
      { {0,0},{0,1},{0,2},{1,0} },
      // 세번째 방향
      { {0,0},{0,1},{1,1},{2,1} },
      // 네번째 방향
      { {0,0},{0,1},{0,2},{-1,2} }
    },
    // ㄴ 블럭 (대칭)
    {
      // 첫번째 방향
      { {0,0},{0,1},{-1,1},{-2,1} },
      // 두번째 방향
      { {0,0},{1,0},{1,1},{1,2} },
      // 세번째 방향
      { {0,0},{0,1},{1,0},{2,0} },
      // 네번째 방향
      { {0,0},{0,1},{0,2},{1,2} }
    },
    // ⨫ 블럭
    {
      // 첫번째 방향
      { {0,0},{1,0},{1,1},{2,1} },
      // 두번째 방향
      { {0,0},{0,1},{-1,1},{-1,2} },
      // 세번째 방향
      { {0,0},{1,0},{1,-1},{2,-1} },
      // 네번째 방향
      { {0,0},{0,1},{1,1},{1,2} }
    },
    // ㅗ 블럭
    {
      // 첫번째 방향
      { {0,0},{0,-1},{0,1},{-1,0} },
      // 두번째 방향
      { {0,0},{-1,0},{1,0},{0,1} },
      // 세번째 방향
      { {0,0},{0,-1},{0,1},{1,0} },
      // 네번째 방향
      { {0,0},{-1,0},{1,0},{0,-1} }
    }
  };

  private static int answer;
  private static int[][] map;
  private static int N,M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][];
    for (int i = 0; i < N; i++) {
      map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    for(int i=0; i<N; i++){
      for(int j=0; j<M; j++){
        for(int k=0; k<6; k++){
          for(int d=0; d<4; d++){
            if(k == 0 && d>1) break;
            if(k == 1 && d>0) break;

            process(i,j,k,d);
          }
        }
      }
    }
    System.out.println(answer);
  }

  private static void process(final int yIdx, final int xIdx, final int type, final int dir) {
    int sum = 0;
    for(int i=0; i<4; i++){
      int nx = yIdx + tetromino[type][dir][i][0];
      int ny = xIdx + tetromino[type][dir][i][1];

      if(nx<0 || ny<0 || nx>= N || ny>=M) return;

      sum += map[nx][ny];
    }

    answer = Math.max(answer,sum);
  }

}
