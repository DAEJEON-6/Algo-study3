package JUNGOL;

import java.util.Scanner;

public class jo_1707 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] map = new int[N][N];

        int number = 1;
        int flag = 1, xPos = -1, yPos = 0;
        int level = N;
        while (true) {
            // x
            for (int i = 0; i < level; i++) {
                xPos += flag;
                map[yPos][xPos] = number++;
            }
            level--;
            if (level <= 0) break;
            // y
            for (int i = 0; i < level; i++) {
                yPos += flag;
                map[yPos][xPos] = number++;
            }

            flag *= -1;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
}
