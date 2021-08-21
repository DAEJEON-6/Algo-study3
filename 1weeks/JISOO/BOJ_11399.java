import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11399 {

	static int[]time;
	static int N;
	static int totalTime; //총 시간

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //사람 수
		time = new int[N]; //각 사람 당 인출하는데 걸리는 시간
		
		for(int i=0; i<N; i++) { //시간 입력 받기
			time[i] = sc.nextInt();
		}
		
		Arrays.sort(time); //시간을 오름차순으로 정렬
		
		totalTime = findTotalTime(0, 0);
		System.out.println(totalTime);
	}

	private static int findTotalTime(int index, int currentSum) { //총 시간의 합 구하기
		
		if(index == N) {
			return currentSum;
		}
		
		for(int i=0; i<=index; i++) { //처음 인덱스부터 현재 자신의 인덱스까지 걸리는 시간 누적
			totalTime = totalTime+time[i];
		}
		
		return findTotalTime(index+1, totalTime);
	}
}
