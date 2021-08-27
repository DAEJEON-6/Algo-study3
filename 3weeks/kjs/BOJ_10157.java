import java.util.Scanner;

public class BOJ_10157 {
	static int C, R;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt(); //열
		R = sc.nextInt(); //행
		int K = sc.nextInt(); //대기번호

		int[][]delta = {{-1,0},{0,1},{1,0},{0,-1}}; //상우하좌 순으로 이동
		int dir = 0;

		if(K > C*R) { //좌석을 배정할 수 없음
			System.out.println(0);
			System.exit(0);
		}

		int[][]map = new int[R][C];

		int curX = R-1; //현재 x좌표
		int curY = 0; //현재 y좌표
		map[curX][curY] = 1;

		int count = 1;
		while(count < K) {

			int tempX = curX + delta[dir][0]; //다음 이동 가능한 위치
			int tempY = curY + delta[dir][1];

			if(checkIndex(tempX, tempY) && map[tempX][tempY]!=1) { //범위 체크 + 이미 좌석이 배정되었는지 확인
				curX = tempX; //위치 이동
				curY = tempY;
				map[curX][curY] = 1; //방문 표시
			}else {
				dir = (dir+1)%4;
				continue;
			}

			count++; //좌석 배정
		}
		
		int concertX = 1+curY; //기존에 사용하던 행,열의 값들을 공연장 배치도에 맞게 변경
		int concertY = R-curX;
		System.out.println(concertX+ " "+concertY);

	}

	private static boolean checkIndex(int tempX, int tempY) { //범위 체크
		if(tempX >= 0 && tempX < R && tempY >= 0 && tempY < C) {
			return true;
		}
		return false;
	}

}
