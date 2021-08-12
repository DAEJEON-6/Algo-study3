package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class boj_2309 {
    private static int[] lengths;
    private static LinkedList<Integer> isVisited;

    private static boolean DFS(int index, int sum, int count) {
        if(count == 7 && sum == 100) {
            isVisited.sort(null);
            for(Integer i : isVisited)
                System.out.println(i);
            return true;
        }
        if(index >= 9)
            return false;

        if(DFS(index+1,sum,count))
            return true;
        isVisited.add(lengths[index]);
        if(DFS(index+1,sum+lengths[index],count+1))
            return true;
        isVisited.pollLast();
        
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        lengths = new int[9];
        isVisited = new LinkedList<>();
        for(int i=0;i<9;i++) {
            lengths[i] = Integer.parseInt(br.readLine());
        }
        DFS(0,0,0);
    }
}
