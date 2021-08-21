import java.util.Scanner;

public class BOJ_2999 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char map[][];
		String str = sc.nextLine();
		int length = str.length();
		int currentMax = 0; //최대 행 번호
		int index = 0; //문자열의 인덱스
		StringBuilder sb = new StringBuilder();

		for(int i=1; i<=length; i++) {
			for(int j=1; j<=length; j++) {
				if(i*j==length && i<=j) { //최대 행 구하기
					currentMax = Integer.max(i, currentMax);
				}
			}
		}

		int row = currentMax;
		int col = length/currentMax;

		map = new char[row][col];

		for(int j=0; j<col; j++) { //입력받은 문자열 저장
			for(int i=0; i<row; i++) {
				map[i][j] = str.charAt(index);
				index++;
			}
		}

		for(int i=0; i<row; i++) { //해독 후 출력
			for(int j=0; j<col; j++) {
				sb.append(map[i][j]);
			}
		}

		System.out.println(sb);

	}

}
