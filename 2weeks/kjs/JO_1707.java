import java.util.Scanner;

public class JO_1707 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[]dx = {0, 1, 0, -1}; //우하좌상 순서
		int[]dy = {1, 0, -1, 0};
		int N = sc.nextInt();
		int[][]map = new int[N][N];
		int curX = 0;
		int curY = 0;
		int dir = 0;

		map[0][0] = 1;
		int count = 2;

		while(count<=N*N) {
			
			int tempX = curX+dx[dir]; //방문 가능성있는 x좌표, y좌표
			int tempY = curY+dy[dir];

			//범위를 벗어난 경우 혹은 이미 입력된 값을 만난 경우 방향을 전환
			if(tempX<0 || tempX>=N || tempY<0 || tempY>=N || map[tempX][tempY]!=0) {
				dir = (dir+1)%dx.length; //새로운 방향 (%연산자 사용)
				continue;
			}

			map[tempX][tempY] = count; //배열에 숫자 저장
			curX = tempX; //현재위치 갱신
			curY = tempY;
			count++; //출력할 숫자 증가
		}

		for(int i=0; i<N; i++) { //출력
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
	}

}
