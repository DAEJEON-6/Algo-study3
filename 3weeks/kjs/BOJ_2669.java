import java.util.Scanner;

public class BOJ_2669 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = 0;

		int[][]map = new int[101][101];

		for(int i=0; i<4; i++) {
			int x1 = sc.nextInt(); //사각형 왼쪽 아래 x좌표
			int y1 = sc.nextInt(); //사각형 왼쪽 아래 y좌표
			int x2 = sc.nextInt(); //사각형 오른쪽 위 x좌표
			int y2 = sc.nextInt(); //사각형 오른쪽 위 y좌표

			for(int j=y1; j<y2; j++) {
				for(int k=x1; k<x2; k++) {
					map[j][k] = 1; //사각형에 포함되는 범위이면 1로 표시
				}
			}
		}

		for(int j=0; j<101; j++) {
			for(int k=0; k<101; k++) {
				if(map[j][k] == 1) { //1의 개수 구하기
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}
