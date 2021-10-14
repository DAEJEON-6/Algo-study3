package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [백준] 연구소 3
 *  출처 : https://www.acmicpc.net/problem/17142
 *  풀이 기법 : BFS
 */

public class boj_17142 {
  private static int N,M;
  private static int[][] map;
  private static int answer = Integer.MAX_VALUE;
  private static ArrayList<int[]> virusPosition;

  private static int[] dx = {0,0,-1,1};
  private static int[] dy = {-1,1,0,0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    virusPosition = new ArrayList<>();
    map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine()," ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 2) {
          virusPosition.add(new int[]{i,j});
        }
      }
    }

    int[][] costs = new int[N][N];
    for (int i = 0; i < N; i++) {
      Arrays.fill(costs[i],Integer.MAX_VALUE);
    }
    for (int i = 0; i <= virusPosition.size()-M; i++) {
      combination(costs,0,i);
    }

    if(answer == Integer.MAX_VALUE)
      answer = -1;
    System.out.println(answer);
  }

  private static void combination(final int[][] costs, final int level, final int virusIdx) {

    int[][] newCosts = new int[N][N];
    for (int i = 0; i < N; i++) {
      newCosts[i] = Arrays.copyOf(costs[i],N);
    }

    //BFS
    PriorityQueue<Node> queue = new PriorityQueue<>();

    int[] startPos = virusPosition.get(virusIdx);
    queue.add(new Node(0,startPos[0],startPos[1]));

    newCosts[startPos[0]][startPos[1]] = 0;

    while(!queue.isEmpty()) {
      Node now = queue.poll();


      for (int i = 0; i < 4; i++) {
        int newX = now.xIdx + dx[i];
        int newY = now.yIdx + dy[i];
        int newCost = now.cost+1;

        if(!isPossible(newY,newX)) continue;
        if(map[newY][newX] == 1) continue;
        if(newCosts[newY][newX] <= newCost) continue;
        newCosts[newY][newX] = newCost;
        queue.add(new Node(newCost,newY,newX));
      }
    }
    if(level == M-1) {
      int maxCost = 0;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if(map[i][j] == 1 || map[i][j] == 2) continue;
          maxCost = Math.max(newCosts[i][j],maxCost);
          if(maxCost == Integer.MAX_VALUE)
            return;
        }
      }

      if(answer > maxCost)
        answer = maxCost;
      return;
    }
    for (int i = virusIdx+1; i < virusPosition.size(); i++) {
      combination(newCosts,level+1,i);
    }
  }

  private static boolean isPossible(final int yIdx, final int xIdx) {
    return !(yIdx < 0 || yIdx >=N || xIdx <0 || xIdx >=N);
  }
  static class Node implements Comparable<Node> {
    private final int cost;
    private final int yIdx;
    private final int xIdx;

    public Node(int cost, int yIdx, int xIdx) {
      this.cost = cost;
      this.yIdx = yIdx;
      this.xIdx = xIdx;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }

}
