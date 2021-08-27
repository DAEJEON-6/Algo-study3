import java.util.Scanner;

public class BOJ_2635 {
	static int secondNum; //두 번째 자리 수의 값
	static int max; //최대 길이

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //첫 번째 자리 수의 값

		for(int i=1; i<=N; i++) { //두 번째 자리 수 모두 구해보기 (단, 첫 번째 자리 수 보다는 같거나 작아야함)
			int second = i;
			countMaxNum(N, second);
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(N+ " "+secondNum+ " "); //첫 번째, 두 번째 자리 수 저장
		
		for(int i=2; i<max; i++) { //최대 개수를 가진 숫자조합 중 하나 저장
			int nextNum = N - secondNum;
			sb.append(nextNum+ " "); //셋째 자리부터 마지막 자리까지 수 저장
			N = secondNum;
			secondNum = nextNum;
		}
		sb.setLength(sb.length()-1);
		System.out.println(max);
		System.out.println(sb);
	}

	private static void countMaxNum(int first, int second) {
		int nextNum = 1; //다음 자리 수
		int count = 2;
		int secondParam = second;
		while(true) { //다음 자리 수가 0보다 작을 때 까지 반복
			nextNum = first-second;
			if(nextNum < 0) {
				break;
			}
			first = second;
			second = nextNum;
			count++;
		}
		if(count > max) {
			max = count; //최대 길이 갱신
			secondNum = secondParam; //두 번째 자리 수의 값 저장
		}
	}

}