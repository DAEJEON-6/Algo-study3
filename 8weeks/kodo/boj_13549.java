package boj;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class boj_13549 {
  private static final int MAX = 100_001;
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N, K;
    N = sc.nextInt();
    K = sc.nextInt();

    int[] isUsed = new int[MAX];
    Arrays.fill(isUsed,MAX);
    PriorityQueue<Node> queue = new PriorityQueue<>();
    queue.add(new Node(0, N));
    isUsed[N] = 0;

    while (!queue.isEmpty()) {
      Node now = queue.poll();

      int nowCost = now.cost;
      int nowIdx = now.idx;

      if (nowIdx == K) {
        System.out.println(nowCost);
        break;
      }

      int nextCost = nowCost + 1;
      if (nowIdx - 1 >= 0 && isUsed[nowIdx - 1] > nextCost) {
        isUsed[nowIdx - 1] = nextCost;
        queue.add(new Node(nextCost, nowIdx - 1));
      }
      if (nowIdx + 1 < MAX && isUsed[nowIdx + 1] > nextCost) {
        isUsed[nowIdx + 1] = nextCost;
        queue.add(new Node(nextCost, nowIdx + 1));
      }
      if (nowIdx * 2 < MAX && isUsed[nowIdx * 2] > nowCost) {
        isUsed[nowIdx * 2] = nowCost;
        queue.add(new Node(nowCost, nowIdx * 2));
      }
    }
  }

  static class Node implements Comparable<Node> {
    private final int cost;
    private final int idx;

    public Node(int cost, int idx) {
      this.cost = cost;
      this.idx = idx;
    }

    @Override
    public int compareTo(Node o) {
      return this.cost - o.cost;
    }
  }
}
