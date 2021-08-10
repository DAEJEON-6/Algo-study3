package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        for(int i=0;i<numbers.length;i++) {
            for(int j=i+1;j< numbers.length;j++) {
                for(int k=j+1;k<numbers.length;k++) {
                    int sum = numbers[i] + numbers[j] + numbers[k];
                    if(sum > M)
                        continue;
                    answer = Math.max(answer, sum);
                }
            }
        }

        System.out.println(answer);
    }
}
