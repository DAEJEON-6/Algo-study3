package boj;

import java.io.*;
import java.util.*;

public class boj_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int SIZE = N-K;

        char[] numbers = br.readLine().toCharArray();

        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0 ; i < numbers.length ; i++) {
            while(K>0 &&!stack.isEmpty() && stack.getLast() < numbers[i]) {
                stack.pollLast();
                K--;
            }
            stack.add(numbers[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append(stack.get(i));
        }

        System.out.println(sb);
    }
}
