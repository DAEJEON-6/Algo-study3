import java.util.Scanner;

public class JO_1523 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //높이
		int M = sc.nextInt(); //종류
		if(N>100 || M>3) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}

		switch (M) {
		case 1:
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i>=j) {
						System.out.print("*");
					}
				}
				System.out.println();
			}
			break;
		case 2:
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i<=j) {
						System.out.print("*");
					}
				}
				System.out.println();
			}			
			break;
		case 3:
			int space = N-1;
			int numStar = 1;
			for(int i=0; i<N; i++) {
				for(int j=0; j<space; j++) { //빈 공간 출력
					System.out.print(" ");
				}
				for(int j=0; j<numStar; j++) { //별 출력
					System.out.print("*");
				}
				System.out.println();
				numStar = numStar + 2;
				space--;
			}
			break;
		}

	}

}
