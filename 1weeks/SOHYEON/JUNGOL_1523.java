package algo.study.jungol;

import java.util.Scanner;

// JUNGOL 1523. 별삼각형1
public class JUNGOL_1523 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int input1 = sc.nextInt();
		int input2 = sc.nextInt();

		if (0 > input1 || 100 < input1 || input2 < 0 || input2 > 3) {
			System.out.println("INPUT ERROR!");
			return;
		}

		switch (input2) {
		case 1:
			for (int i = 1; i <= input1; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 2:
			for (int i = input1; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		case 3:
			for (int i = 0; i < input1; i++) {
				for (int j = 1; j < input1 - i; j++) {  // 공백
					System.out.print(" ");
				}
				for (int k = 0; k < 2 * i + 1; k++) {  // 별
					System.out.print("*");
				}
				System.out.println();
			}
			break;
		}
		sc.close();
	}
}
