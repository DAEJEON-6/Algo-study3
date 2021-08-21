import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2605 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> order = new ArrayList<>();
		int N = sc.nextInt();

		order.add(1); //처음 온 학생은 1번으로 초기화
		sc.nextInt(); //처음 입력받은 0 날리기
		
		for(int i=2; i<=N; i++) {
			int number = sc.nextInt(); //먼저 번호뽑고, 현재 길이로부터 뽑은 숫자만큼 앞으로가 줄을 선다
			order.add(order.size()-number, i);
		}
		
		for(int i=0; i<N; i++) { //출력
			System.out.print(order.get(i)+ " ");
		}
		
	}

}
