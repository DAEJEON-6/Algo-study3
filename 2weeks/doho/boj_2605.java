package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_2605 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=N;i++) {
            int index = Integer.parseInt(st.nextToken());
            index = list.size() - index;
            list.add(index,i);
        }
        for(int i : list) {
            System.out.print(i + " ");
        }
    }
}
