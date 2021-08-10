package SWEA;

import java.util.Scanner;

public class swea_1859 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] prices = new int[N];
            for(int i=0;i<N;i++)
                prices[i] = sc.nextInt();

            long profit = 0;
            int pivot = 0;
            for(int i=N-1;i>=0;i--) {
                if(pivot < prices[i])
                    pivot = prices[i];
                profit += (pivot - prices[i]);
            }
            System.out.println("#"+test_case+" "+profit);
        }
    }
}
