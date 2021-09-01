package algo.study.jungol;

import java.util.Scanner;

// JUNGOL 1719. 별삼각형2
public class JUNGOL_1719 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // 삼각형 크기 n
		int m = sc.nextInt();  // 삼각형 종류 m
		if(n<0 || n>100 || m <1 || m>4 || n%2==0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		int height = n/2;
		switch(m) {
		case 1:
			for (int i = 0; i < n; i++) {
				if (i <=height) {
					for (int j = 0; j <= i; j++) {
						System.out.printf("*");
					}
					System.out.println();
				}
				if (i > height) {
					for (int k = n - i; k > 0; k--) {
						System.out.printf("*");
					}
					System.out.println();
				}
			}
			break;
		case 2:
			for (int i = 0; i < n; i++) {
				if (i <= height) {
					for (int j = height - i; j > 0; j--) {
						System.out.printf(" ");
					}
					for (int k = 0; k <= i; k++) {
						System.out.printf("*");
					}
					System.out.println();
				}
				if (i > height) {
					for (int j = 0; j < i - height; j++) {
						System.out.printf(" ");
					}
					for (int k = n - i; k > 0; k--) {
						System.out.printf("*");
					}
					System.out.println();
				}
			}
			break;
		case 3:
			for (int i = 0; i < n; i++) {
				if (i <= height) {
					for (int j = 1; j <= i; j++) {
						System.out.printf(" ");
					}
					for (int k = n; k > 2 * i; k--) {
						System.out.printf("*");
					}
					System.out.println();
				}
				if (i > height) {
					for (int j = n - i - 1; j > 0; j--) {
						System.out.printf(" ");
					}
					for (int k = n - 1; k < 2 * i + 1; k++) {
						System.out.printf("*");
					}
					System.out.println();
				}
			}
			break;
		case 4:
			for (int i = 0; i < n; i++) {
				if (i <= height) {
					for (int j = 1; j <= i; j++) {
						System.out.printf(" ");
					}
					for (int k = height + 1; k > i; k--) {
						System.out.printf("*");
					}
					System.out.println();
				}

				if (i > height) {
					for (int j = 1; j <= height; j++) {
						System.out.printf(" ");
					}
					for (int k = height - 1; k < i; k++) {
						System.out.printf("*");
					}
					System.out.println();

				}
			}
			break;
		}
		sc.close();
	}

}
