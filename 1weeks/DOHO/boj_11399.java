package boj;

import java.util.Arrays;
import java.util.Scanner;

public class boj_11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] costs = new int[N];
        for(int i=0;i<N;i++) {
            costs[i] = sc.nextInt();
        }

        Arrays.sort(costs);
        int answer = 0;
        int sum = 0;
        for(int i : costs) {
            sum += i;
            answer += sum;
        }
        System.out.println(answer);
    }
}
