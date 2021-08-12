package boj;

import java.util.Scanner;

public class boj_2999 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int R = 0;
        int C = 0;
        int N = input.length();

        for(int i=N;i>0;i--) {
            for(int j=1;j<=i;j++) {
                if(i*j == N) {
                    if(R < j) {
                        R = j;
                        C = i;
                    }
                }
            }
        }

        char[][] map = new char[R][C];
        int index = 0;
        for(int i=0;i<C;i++) {
            for(int j=0;j<R;j++)
                map[j][i] = input.charAt(index++);
        }

        StringBuilder sb = new StringBuilder();
        for(char[] array : map) {
            for(char c : array)
                sb.append(c);
        }
        System.out.println(sb);
    }
}
