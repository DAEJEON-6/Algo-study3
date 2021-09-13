package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_2812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=numbers.length-1 ; i >= 0; i--) {
            if(stack.size() < (N-K)) {
                stack.addFirst(numbers[i]);
                continue;
            }

            if(stack.get(0) <= numbers[i]) {
                if(stack.get(0) < numbers[i] && (i+1 + stack.size()) >= (N-K))
                    stack.pollFirst();
                stack.addFirst(numbers[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N-K; i++) {
            sb.append(stack.get(i));
        }

        System.out.println(sb);
    }
}
