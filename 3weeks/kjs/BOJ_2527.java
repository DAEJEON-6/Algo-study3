import java.util.Scanner;

public class BOJ_2527 {

	static int[]map1;
	static int[]map2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map1 = new int[4];
		map2 = new int[4];

		for(int i=0; i<4; i++) {			
			for(int j=0; j<4; j++) { //첫 번째 직사각형의 좌표
				map1[j] = sc.nextInt();
			}

			for(int j=0; j<4; j++) { //두 번째 직사각형의 좌표
				map2[j] = sc.nextInt();
			}		

			System.out.println(findCommonParts());
		}
	}

	private static char findCommonParts() { //공통부분 찾기
		char answer = ' ';
		if(checkPoint()) {
			answer = 'c';
		}else if(checkLine()) {
			answer = 'b';
		}else if(checkNone()) {
			answer = 'd';
		}else {
			answer = 'a';
		}
		return answer;
	}

	/*
	 * 두 직사각형의 공통부분이 없음:
	 * rec1의 끝 x < rec2의 시작 x 이거나 rec1의 시작 x > rec2의 끝 x
	 * y좌표도 마찬가지로 적용됨
	 */
	private static boolean checkNone() {
		if(map1[2]<map2[0] || map1[0]>map2[2] || map1[3]<map2[1] || map1[1]>map2[3] ) {
			return true;
		}
		return false;
	}

	/*
	 * 두 직사각형의 공통부분이 선분:
	 * rec1의 한 꼭짓점의 x,y좌표 중 하나가 rec2의 한 꼭짓점의 x,y좌표 중 하나와 같다. (x,y좌표가 둘 다 같을 수는 없다, 그 경우는 공통부분이 점)
	 */
	private static boolean checkLine() {
		if((map1[2]==map2[0]&&map1[3]!=map2[1])  || (map1[2]==map2[0]&&map1[1]!=map2[3]) ||
				(map1[0]==map2[2]&&map1[1]!=map2[3]) || (map1[0]==map2[2]&&map1[3]!=map2[1]) ||
				(map1[2]!=map2[0]&&map1[3]==map2[1])  || (map1[2]!=map2[0]&&map1[1]==map2[3]) ||
				(map1[0]!=map2[2]&&map1[1]==map2[3]) || (map1[0]!=map2[2]&&map1[3]==map2[1])) {
			return true;
		}
		return false;
	}

	/*
	 * 두 직사각형의 공통부분이 점:
	 * rec1의 한 꼭짓점의 x,y좌표가 rec2의 한 꼭짓점의 x,y좌표와 같다 
	 */
	private static boolean checkPoint() {
		if((map1[2]==map2[0]&&map1[3]==map2[1])  || (map1[2]==map2[0]&&map1[1]==map2[3]) ||
				(map1[0]==map2[2]&&map1[1]==map2[3]) || (map1[0]==map2[2]&&map1[3]==map2[1])) {
			return true;
		}
		return false;
	}

}
