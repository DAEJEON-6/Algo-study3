import java.util.Scanner;

public class BOJ_1592 {
	
	static int[] friends;
	static int N;
	static int M;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //사람 수
		M = sc.nextInt(); //게임이 종료되기위해 요구되는 한 사람이 공을 받는 횟수
		int L = sc.nextInt(); //시계 혹은 반시계 방향으로 몇번째 사람에게 던지는지
		friends = new int[N];
		friends[0] = 1; //첫번째 사람이 처음 공을 받음
		int from = 0; //공을 던지는 사람의 인덱스 (첫번째 사람으로 초기화)
		boolean clockwise; //공을 던지는 방향
		
		while(true) {
			clockwise = isClockWise(from);
			from = throwBall(clockwise, from , L); //공을 던질 사람을 갱신
			if(gameEnded()) {
				break;
			}
		}
		
		System.out.println(count);
	}

	private static boolean isClockWise(int from) { //공을 어느방향으로 던질지 확인
		if(friends[from]%2 == 1) { //현재 공을 홀수번만큼 받았으면 시계방향으로 던짐
			return true;
		}else { //현재 공을 짝수번만큼 받았으면 시계방향으로 던짐
			return false;
		}
	}

	private static boolean gameEnded() { //게임을 종료할지 체크하는 메서드
		for(int i=0; i<N; i++) {
			if(friends[i] == M) { //M번 공을 받은 사람이 있을 경우 게임을 종료
				return true;
			}
		}
		return false;
	}

	private static int throwBall(boolean clockwise, int from, int to) { //공을 받은 사람의 인덱스 리턴
		int next;
		if(clockwise) { //공을 던질 방향이 시계방향일 경우
			next = (from+to)%N; //시계방향으로 to만큼 간다고 생각
			friends[next]++; //공을 받은 사람의 공 받은 횟수를 올려준다
			
		}else { //공을 던질 방향이 반시계 방향일 경우 
			next = (from+N-to)%N; //반시계방향을 생각하지 말고, 현 위치에서 시계방향으로 N-to만큼 간다고 생각
			friends[next]++; //공을 받은 사람의 공 받은 횟수를 올려준다
		}
		count++;
		return next;
	}

}
