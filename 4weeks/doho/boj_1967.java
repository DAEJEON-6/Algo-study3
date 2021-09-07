package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_1967 {
    private static int maxCost;
    private static int maxIndex;

    private static int N;
    private static LinkedList<Integer[]>[] path;

    private static void DFS(final int startIndex, boolean[] isVisited, final int cost) {
        isVisited[startIndex] = true;
        if(maxCost < cost) {
            maxCost  = cost;
            maxIndex = startIndex;
        }

        for(Integer[] i : path[startIndex]) {
            if(isVisited[i[0]]) continue;
            DFS(i[0],isVisited,cost + i[1]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        path = new LinkedList[N];
        for(int i=0;i<N;i++)
            path[i] = new LinkedList<>();

        for(int i=0;i<N-1;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());

            path[a].add(new Integer[] {b,cost});
            path[b].add(new Integer[] {a,cost});
        }

        DFS(0,new boolean[N],0);
        maxCost = 0;
        DFS(maxIndex, new boolean[N],0);
        System.out.println(maxCost);
    }
}

/*
[Test]
5
1 3 2
3 4 3
4 2 4
4 5 6
: 11
 */