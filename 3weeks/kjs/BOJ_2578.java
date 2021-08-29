import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2578 {
	static int[][]map; //철수의 빙고판
	static int[]order; //사회자가 부르는 수 (순서대로)
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];
		order = new int[25];
		int index = 0;
		StringTokenizer st;

		for(int i=0; i<5; i++) { //철수의 빙고판 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<5; i++) { //사회자가 부르는 수 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken());
				order[index] = num;
				index++;
			}
		}

		System.out.println(callNumber());
	}

	private static int callNumber() {

		for(int i=0; i<25; i++) {
			eraseNumber(order[i]); 
			//if(i >= 12) { //최소 13개의 숫자가 불린 경우, 빙고 체크
				if(checkBingo()) {
					return i+1;
				}
			//}
		}
		return 0;
	}

	private static void eraseNumber(int num) { //빙고판에서 사회자가 부른 숫자를 지움
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(map[i][j] == num) {
					map[i][j] = 0;
					break;
				}
			}
		}
	}

	private static boolean checkBingo() { //빙고 체크
		int countBingo = 0;

		for(int i=0; i<5; i++) { //가로 체크
			if(map[i][0]==0&&map[i][1]==0&&map[i][2]==0&&map[i][3]==0&&map[i][4]==0) {
				countBingo++;
			}
		}

		for(int i=0; i<5; i++) { //세로 체크
			if(map[0][i]==0&&map[1][i]==0&&map[2][i]==0&&map[3][i]==0&&map[4][i]==0) {
				countBingo++;
			}
		}

		if(map[4][0]==0&&map[3][1]==0&&map[2][2]==0&&map[1][3]==0&&map[0][4]==0) { //우상 대각선 체크
			countBingo++;
		}

		if(map[0][0]==0&&map[1][1]==0&&map[2][2]==0&&map[3][3]==0&&map[4][4]==0) { //우하 대각선 체크
			countBingo++; 
		}

		if(countBingo >= 3) {
			return true;
		}else {
			return false;
		}
	}
}
