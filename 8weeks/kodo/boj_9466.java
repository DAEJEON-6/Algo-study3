package boj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준 - 텀 프로젝트
 *  출처 : https://www.acmicpc.net/problem/9466
 *  문제 구분 : Graph
 */

public class boj_9466 {
  private static int count = 0;
  private static int[] target;
  private static int[] isVisited;
  private static boolean[] isCycleCheck;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int T = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= T; testCase++) {
      int N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      target = new int[N];
      for (int i = 0; i < N; i++) {
        target[i] = Integer.parseInt(st.nextToken())-1;
      }
      count=0;
      isVisited = new int[N];
      isCycleCheck = new boolean[N];
      int loopCount = 1;
      for (int i = 0; i < N; i++) {
        if(isVisited[i] != 0) continue;
        DFS(i, loopCount);
        loopCount++;
      }
      bw.write((N-count)+"\n");
    }
    bw.close();
  }

  private static void DFS(final int idx, final int loopCount) {
    isVisited[idx] = loopCount;

    if(isVisited[target[idx]] == 0) {
      DFS(target[idx],loopCount);
    } else if (isVisited[target[idx]] == loopCount) {
      // cycle!
      if(!isCycleCheck[target[idx]]) {
        for (int i = target[idx]; i != idx ; i = target[i]) {
         count++;
        }
        count++;
      }
    }
    isCycleCheck[idx] = true;
  }
}
