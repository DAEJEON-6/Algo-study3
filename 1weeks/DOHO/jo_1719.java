package JUNGOL;

import java.util.Scanner;

public class jo_1719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        if(N < 0 || N > 100 || N%2 == 0 || M < 1 || M > 4) {
            System.out.println("INPUT ERROR!");
            return;
        }
        switch (M) {
            case 1:
                for(int i=0;i<=N/2;i++) {
                    for(int j=0;j<=i;j++)
                        System.out.print('*');
                    System.out.println();
                }
                for(int i=0;i<(N/2);i++) {
                    for(int j=N/2-i;j>0;j--)
                        System.out.print('*');
                    System.out.println();
                }
                break;
            case 2:
                for(int i=N/2;i>=0;i--) {
                    for(int j=0;j<i;j++)
                        System.out.print(' ');
                    for(int j=0;j<=N/2-i;j++)
                        System.out.print('*');
                    System.out.println();
                }
                for(int i=0;i<N/2;i++) {
                    for(int j=0;j<=i;j++)
                        System.out.print(' ');
                    for(int j=N/2-i;j>0;j--)
                        System.out.print('*');
                    System.out.println();
                }
                break;
            case 3:
                for(int i=0;i<=N/2;i++) {
                    for(int j=0;j<i;j++)
                        System.out.print(' ');
                    for(int j=N-(2*i);j>0;j--)
                        System.out.print('*');
                    System.out.println();
                }
                for(int i=1;i<=N/2;i++) {
                    for(int j=N/2-i;j>0;j--)
                        System.out.print(' ');
                    for(int j=(1+i*2);j>0;j--)
                        System.out.print('*');
                    System.out.println();
                }
                break;
            case 4:
                for(int i=0;i<=N/2;i++) {
                    for(int j=0;j<i;j++)
                        System.out.print(' ');
                    for(int j=N/2-i;j>=0;j--)
                        System.out.print('*');
                    System.out.println();
                }
                for(int i=0;i<N/2;i++) {
                    for(int j=0;j<N/2;j++)
                        System.out.print(' ');
                    for(int j=0;j<=i+1;j++)
                        System.out.print('*');
                    System.out.println();
                }
                break;
        }
    }
}
