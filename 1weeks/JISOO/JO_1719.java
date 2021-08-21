import java.util.Arrays;
import java.util.Scanner;

public class JO_1719 {

	static int N;; //삼각형의 높이
	static int M; //출력할 종류
	static char[][]map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][N];
		int numStar = N;
		int numSpace = 0;

		for(int i=0; i<N; i++) { //배열을 공백으로 초기화
			Arrays.fill(map[i], ' ');
		}

		if((N>100 || N%2==0) || (M<1 || M>4)){
			System.out.print("INPUT ERROR!");
		}

		else {
			switch (M) {
			case 1:

				typeOne();
				print();
				break;

			case 2:

				typeOne();
				for(int i=0; i<2; i++) {
					rotate();
				}
				print();	
				break;

			case 3:

				for(int i=0; i<=N/2; i++) { //중점 위 부분의 삼각형 출력 (중점 포함)	
					for(int j=numSpace; j<numStar; j++) {
						map[i][j] = '*';
					}
					numStar--;
					numSpace++;
				}
				numSpace = numSpace - 2;
				numStar = numStar + 2;

				for(int i=N/2+1; i<N; i++) { //중점 아래 부분의 삼각형 출력
					for(int j=numSpace; j<numStar; j++) {
						map[i][j] = '*';
					}
					numStar++;
					numSpace--;
				}

				print();
				break;

			case 4:
				numStar = (numStar/2)+1;
				for(int i=0; i<=N/2; i++) { //중점 위 부분의 삼각형 출력 (중점 포함)	
					for(int j=numSpace; j<numStar; j++) {
						map[i][j] = '*';
					}
					numSpace++;
				}

				numSpace--;
				numStar++;

				for(int i=N/2+1; i<N; i++) { //중점 아래 부분의 삼각형 출력
					for(int j=numSpace; j<numStar; j++) { 
						map[i][j] = '*';
					}
					numStar++;
				}

				print();
				break;
			}
		}
	}

	private static void rotate() { //배열을 시계방향으로 90도 회전시키는 메서드

		char[][]temp = new char[N][N]; //90도 회전된 배열을 저장할 새로운 배열 생성(값이 덮어씌워지는것을 방지)

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int repX = N-1-j;
				int repY = i;

				char repVal = map[repX][repY];
				temp[i][j] = repVal;
			}
		}
		map = temp; //기존 배열이 현재 90도로 회전된 배열을 가리키게함
	}

	private static void print() { //배열 출력
		for(int i=0; i<N; i++) { 
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void typeOne() { //종류1을 생성
		int numStar = 1;
		boolean upward = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<numStar; j++) {
				if(i==N/2 && j==N/2) { //x,y가 중점에 도달했을 경우 별의 개수를 줄여준다
					upward = false;
				}
				map[i][j] = '*';
			}
			if(upward) {
				numStar++;
			}else {
				numStar--;
			}
		}
	}
}
